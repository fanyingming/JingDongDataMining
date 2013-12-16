package cn.edu.pku.ss.jddatamining.crawl;
import cn.edu.pku.ss.jddatamining.util.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CommentAnalyzer extends Thread{
	
	private DBManage dbManager;
	private static long lastTime;
	private static long currentTime;
	private long timeThres = GlobalConfig.timeThres;
	
	public CommentAnalyzer(DBManage dbManager){
		this.dbManager = dbManager;
	}

	public void run() {
		lastTime = System.currentTimeMillis();
		currentTime = System.currentTimeMillis();
		// getDetaiUrl();
		Connection conn = dbManager.getConnection();
		while (true) {
			currentTime = System.currentTimeMillis();
			if(currentTime - lastTime > timeThres )
				break;
			String CommentNumSel = "div.content>div>a>font[color=orange]";
			String commentContenSel = "div.content>div.eval>div.u-summ";
			String commentUrl = getCommentUrl(conn);
			if(commentUrl == "")
				continue;
			System.out.println("开始分析商品评论：" + commentUrl);
			try {
				Thread.sleep(50);
				// getComment
				Document doc = Jsoup.connect(commentUrl).get();
				int goodNum = Integer.parseInt(doc.select(CommentNumSel).get(0).text());
				int mediumNum = Integer.parseInt(doc.select(CommentNumSel).get(1).text());
				int badNum = Integer.parseInt(doc.select(CommentNumSel).get(2).text());
				String commentContent = getMaxString(doc.select(commentContenSel).text().replaceAll("'", " "));
//				System.out.println(commentContent);
				// update db
				Statement stmt = conn.createStatement();
				String updateCommentSql = "UPDATE IGNORE items SET " +
						"isCommentAnalyzed = 1," +
						"goodCommentNum = " + goodNum + "," +
						"mediumCommentNum = " + mediumNum + "," +
						"badCommentNum = " + badNum + "," +
						"commentContent = '" +commentContent +"'" +
						"WHERE commentUrl = '" + commentUrl + "'";
				stmt.executeUpdate(updateCommentSql);
				stmt.close();
			} catch (IOException | SQLException | InterruptedException e) {
				e.printStackTrace();
			}
			lastTime = currentTime;
		}
	}

	public String getCommentUrl(Connection conn) {
		String detailUrl = "";
		try {
			Statement stmt = conn.createStatement();
			String getUrlCmd = "SELECT commentUrl FROM items where isCommentAnalyzed = 0 limit 1";
			ResultSet rs = stmt.executeQuery(getUrlCmd);
			while (rs.next()) {
				detailUrl = rs.getString("commentUrl");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detailUrl;
	}
	private String getMaxString(String input)
	{
		String output = "";
		int iLength = input.length();
		int maxLength = 800;
		int length = Math.min(maxLength, iLength);
		output = input.substring(0,length);
		return output;
	}
}