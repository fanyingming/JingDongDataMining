package cn.edu.pku.ss;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebPageAnalyzer {
	// 从数据库中取出未经过分析的网页进行分析，提取其中的价格、评论等信息
	public void Start() {
		Connection conn = Spider.getConnection();
		String itemUrl = getItemUrl(conn);
		Document doc;
		System.out.println("开始分析：" + itemUrl);
//			doc = Jsoup.connect(itemUrl).get();
		doc = Spider.getWebPage(itemUrl);
		String title = doc.title();
		String html = doc.toString();
		System.out.println(html);
		String priceStr = "strong#jd-price.p-price";
		String price = doc.select(priceStr).text();
		double d_price = convertToDouble(price);
	}

	private double convertToDouble(String price) {
		
		return 0;
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
