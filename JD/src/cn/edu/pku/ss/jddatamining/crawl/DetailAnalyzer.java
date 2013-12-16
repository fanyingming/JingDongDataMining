package cn.edu.pku.ss.jddatamining.crawl;
import cn.edu.pku.ss.jddatamining.util.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DetailAnalyzer extends Thread{
	private DBManage dbManager;
	private static long lastTime;
	private static long currentTime;
	private long timeThres = GlobalConfig.timeThres;
	
	public DetailAnalyzer(DBManage dbmanager){
		this.dbManager = dbmanager;
	}
	public void run() {
		Connection conn = dbManager.getConnection();
		lastTime = System.currentTimeMillis();
		currentTime = System.currentTimeMillis();
		while (true) {
			currentTime = System.currentTimeMillis();
			if(currentTime - lastTime > timeThres )
				break;
			// get detail url
			String detailUrl = getDetailUrl(conn);
			if(detailUrl == "")
				continue;
			// get detail
			try {
				Thread.sleep(50);
				System.out.println("开始分析商品详细：" + detailUrl);
				Document doc = Jsoup.connect(detailUrl).get();
				String detailContentSel = "div.content>div.m3>div.mc>table.Ptable>tbody>tr>td";
				Elements detailsContent = doc.select(detailContentSel);
				HashMap<String, String> detailsTable = new HashMap<>();
				for(int i = 0;i < detailsContent.size();i+=2) {
					String key = detailsContent.get(i).text();
					String value = detailsContent.get(i + 1).text();
					detailsTable.put(key, value);
				}
				
				//update details
				Statement stmt = conn.createStatement();
				String detailsSql = "UPDATE items SET " +
						"isDetailAnalyzed = 1 ," +
						"brand = '" + detailsTable.get("品牌") + "'," +
						"model = '" + detailsTable.get("型号") + "'," +
						"color = '" + detailsTable.get("颜色") + "'," +
						"platform = '" + detailsTable.get("平台") + "'," +
						"os = '" + detailsTable.get("操作系统") + "'," +
						"cpuType = '" + detailsTable.get("CPU型号") + "'," +
						"ram = '" + detailsTable.get("内存容量") + "'," +
						"hardDrive = '" + detailsTable.get("硬盘容量") + "'," +
						"cdRom = '" + detailsTable.get("光驱类型") + "'," +
						"monitor = '" + detailsTable.get("屏幕规格") + "'," +
						"weight = '" + detailsTable.get("净重") + "'," +
						"size = '" + detailsTable.get("尺寸") + "' " +
						"WHERE detailUrl = '" + detailUrl + "'"; 
				stmt.executeUpdate(detailsSql);
				stmt.close();
				
			} catch (IOException | SQLException | InterruptedException e) {
				e.printStackTrace();
			}
			lastTime = currentTime;
		}
	}

	public String getDetailUrl(Connection conn) {
		String detailUrl = "";
		try {
			Statement stmt = conn.createStatement();
			String getSql = "SELECT detailUrl from items where isDetailAnalyzed = 0 LIMIT 1";
			ResultSet rs = stmt.executeQuery(getSql);
			while (rs.next()) {
				detailUrl = rs.getString("detailUrl");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detailUrl;
	}
}
