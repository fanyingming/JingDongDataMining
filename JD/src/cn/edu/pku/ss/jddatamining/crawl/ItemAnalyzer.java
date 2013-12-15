package cn.edu.pku.ss;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ItemAnalyzer extends Thread{
	private DBManage dbManager;
	public ItemAnalyzer(DBManage dbManger){
		this.dbManager = dbManger;
	}
	// 从数据库中取出未经过分析的网页进行分析，提取其中的价格、评论等信息
	public void run() {
		Connection conn = dbManager.initTable_items();// init db
		while (true) {
			String itemUrl = getItemUrl(conn);
			String itemUrlMD5 = EncryptionByMD5.getMD5(itemUrl);
			if(itemUrl.equals(""))
				continue;
			System.out.println("开始分析商品：" + itemUrl);
			// get-title
			Document doc;
			String title = "";
			try {
				Thread.sleep(50);
				doc = Jsoup.connect(itemUrl).get();
				title = doc.title();
				title = title.replace('\'', ' '); // 如果title有'则会造成异常
				// get price
				String priceSel = "div.content.content2>div.p-price>font";
				String sPrice = "";double price = -1;
				sPrice = doc.select(priceSel).first().text().replaceAll("[^\\d+\\.]", "");
				if(!sPrice.equalsIgnoreCase("")){
					price = Double.parseDouble(sPrice);
				}
				// get deitalUrl commentUrl
				String detaiCommentUrlsSel = "div.content.content2>div.tab>a";
				String detailUrl = doc.select(detaiCommentUrlsSel).get(1)
						.attr("abs:href");
				String commentUrl = doc.select(detaiCommentUrlsSel).get(2)
						.attr("abs:href");
			// update DB
				Statement stmt = conn.createStatement();
				String insertSql = "insert ignore into items " +
						"(itemUrlMD5,itemUrl,detailUrl,commentUrl,title,price,isDetailAnalyzed,isCommentAnalyzed)" +
						" values ('"
						+ itemUrlMD5
						+ "','"
						+ itemUrl
						+ "','"
						+ detailUrl 
						+"','"
						+ commentUrl
						+ "','"
						+ title
						+ "',"
						+ price 
						+ ",0" 
						+ ",0"
						+ ")";
				stmt.executeUpdate(insertSql);
				// update urls
				String updateSql = "update urls set IsAnalyzed =  1 where UrlMD5 = '"
						+ itemUrlMD5 + "'";
				stmt.executeUpdate(updateSql);

				stmt.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemUrl;
	}
}
