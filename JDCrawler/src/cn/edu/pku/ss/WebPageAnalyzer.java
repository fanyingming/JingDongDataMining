package cn.edu.pku.ss;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebPageAnalyzer {
	// 从数据库中取出未经过分析的网页进行分析，提取其中的价格、评论等信息
	public void Start() {
		Connection conn = initDB();// init db
		while (true) {
			String itemUrl = getItemUrl(conn);
			String itemUrlMD5 = EncryptionByMD5.getMD5(itemUrl);
			System.out.println("开始分析：" + itemUrl);
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
			//如果title有'则会造成异常
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
		// 如果不存在数据库则新建数据库,建立相应的表
		try {
			Statement stmt = conn.createStatement();
			String createTable = "CREATE TABLE IF NOT EXISTS `results` ( `UrlMD5` varchar(80) NOT NULL, `Url` varchar(400) default NULL, `Title` varchar(400) default NULL, `Price` double default NULL, PRIMARY KEY  (`UrlMD5`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
			stmt.execute(createTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果存在数据库则直接返回数据库连接
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
