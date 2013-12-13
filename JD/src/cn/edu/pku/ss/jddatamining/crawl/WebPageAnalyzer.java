package cn.edu.pku.ss.jddatamining.crawl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebPageAnalyzer {
	// 浠庢暟鎹簱涓彇鍑烘湭缁忚繃鍒嗘瀽鐨勭綉椤佃繘琛屽垎鏋愶紝鎻愬彇鍏朵腑鐨勪环鏍笺�璇勮绛変俊鎭�
	public void Start() {
		Connection conn = initDB();// init db
		while (true) {
			String itemUrl = getItemUrl(conn);
			String itemUrlMD5 = EncryptionByMD5.getMD5(itemUrl);
			System.out.println("寮�鍒嗘瀽锛� + itemUrl);
			//get-price
			// http://p.3.cn/prices/get?skuid=J_982040&type=1&area=1_72_4137&callback=cnp
			String itemID = itemUrl.replaceAll(
					"^http://item.jd.com/(\\d+).html$", "$1");
			String getItemPriceUrl = "http://p.3.cn/prices/get?skuid=J_"
					+ itemID + "&type=1&area=1_72_4137&callback=cnp";
			double itemPrice = 0;
			try {
				Document priceDoc = Spider.getWebPage(getItemPriceUrl);
				String cnp = priceDoc.select("body").text();
				String sPrice = cnp.replaceAll("^.*\"p\":\"(.*)\",.*$", "$1");
				itemPrice = Double.parseDouble(sPrice);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get-title
			Document doc = Spider.getWebPage(itemUrl);
			String title = doc.title();
			//濡傛灉title鏈�鍒欎細閫犳垚寮傚父
			title  = title.replace('\'', ' ');
			//update DB
			// insert into results
			try {
				Statement stmt = conn.createStatement();
				String insertSql = "insert ignore into results (UrlMD5,Url,Title,Price) values ('"
						+ itemUrlMD5
						+ "','"
						+ itemUrl
						+ "','"
						+ title
						+ "',"
						+ itemPrice + ")";
				stmt.executeUpdate(insertSql);
				// update urls
				String updateSql = "update urls set IsAnalyzed =  1 where UrlMD5 = '"
						+ itemUrlMD5 + "'";
				stmt.executeUpdate(updateSql);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Connection initDB() {
		Connection conn = Spider.getConnection();
		// 濡傛灉涓嶅瓨鍦ㄦ暟鎹簱鍒欐柊寤烘暟鎹簱,寤虹珛鐩稿簲鐨勮〃
		try {
			Statement stmt = conn.createStatement();
			String createTable = "CREATE TABLE IF NOT EXISTS `results` ( `UrlMD5` varchar(80) NOT NULL, `Url` varchar(400) default NULL, `Title` varchar(400) default NULL, `Price` double default NULL, PRIMARY KEY  (`UrlMD5`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
			stmt.execute(createTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 濡傛灉瀛樺湪鏁版嵁搴撳垯鐩存帴杩斿洖鏁版嵁搴撹繛鎺�
		return conn;
	}

	private String getItemUrl(Connection conn) {
		String itemUrl = "";
		try {
			Statement stmt = conn.createStatement();
			String selectItem = "select url from urls where depth = 1 and isAnalyzed = 0 order by inserttime limit 1";
			ResultSet rs = stmt.executeQuery(selectItem);
			while (rs.next()) {
				itemUrl = rs.getString("Url");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemUrl;
	}

}
