package cn.edu.pku.ss;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.sql.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider extends Thread {
	private String srcURL;
	private DBManage dbManager;

	public Spider(String srcUrl, DBManage dbManager) {
		this.srcURL = srcUrl;
		this.dbManager = dbManager;
	}

	public void run() {
		Connection conn = dbManager.initTable_urls(this.srcURL);
		while (true) {
			try {
				Thread.sleep(50);
				String url = getSrcUrl(conn);
				if (url.equals(""))
					continue;
				System.out.println("开始爬取：" + url);
				crawlOnePage(url, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String getSrcUrl(Connection conn) {
		String url = "";
		try {
			Statement stmt = conn.createStatement();
			String srcUrl = "select url from urls where depth = 0 and IsAnalyzed = 0 order by InsertTime limit 1";
			ResultSet row = stmt.executeQuery(srcUrl);
			while (row.next()) {
				url = row.getString("Url");
			}
			row.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

	public void crawlOnePage(String url, Connection conn) throws IOException,
			SQLException {
		Document doc = getWebPage(url);
		HashMap<String, Integer> urls = ExtractUrls(doc);
		addUrlsToDB(conn, urls);
		String urlmd5 = EncryptionByMD5.getMD5(url);
		UpdataCrawState(conn, urlmd5);
	}

	private boolean UpdataCrawState(Connection conn, String urlMD5) {
		boolean bRet = false;
		try {
			Statement stmt = conn.createStatement();
			String update = "update urls set IsAnalyzed = 1 where Urlmd5 = '"
					+ urlMD5 + "'";
			stmt.executeUpdate(update);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bRet;
	}

	public static Document getWebPage(String url) {
		Document document = null;
		try {
			URL uurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) uurl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty(
					"User-Agent",
					"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");
			conn.setConnectTimeout(40000);
			conn.setReadTimeout(40000);

			InputStream inputStream = conn.getInputStream();
			document = Jsoup.parse(inputStream, "utf-8", url);

			conn.disconnect();
		} catch (MalformedURLException e) {
			System.out.println(" 获取网页问题报错");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(" 获取网页报错");
			e.printStackTrace();
		}
		return document;
	}

	private HashMap<String, Integer> ExtractUrls(Document doc) {
		HashMap<String, Integer> urls = new HashMap<String, Integer>();
		String itemSelect = "div.pmc>div.title>a[href]";
		Elements itemUrls = doc.select(itemSelect);
		for (Element item : itemUrls) {
			String url = item.attr("abs:href");
			urls.put(url, 1);
		}
		// page urls:depth = 0
		String pageSelect = "div.page>a[href]";
		Elements pageUrls = doc.select(pageSelect);
		for (Element page : pageUrls) {
			String url = page.attr("abs:href");
			urls.put(url, 0);
		}
		return urls;
	}

	private boolean addUrlsToDB(Connection conn, HashMap<String, Integer> urls)
			throws SQLException {
		boolean bRet = false;
		Iterator<Map.Entry<String, Integer>> it = urls.entrySet().iterator();
		Statement stmt = conn.createStatement();
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			String url = (String) entry.getKey();
			String urlmd5 = EncryptionByMD5.getMD5(url);
			int depth = (int) entry.getValue();
			String sql = "insert ignore into urls (UrlMD5,Url,Depth,IsAnalyzed,InsertTime) values ('"
					+ urlmd5 + "','" + url + "'," + depth + ",0,now())";
			try {
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		stmt.close();
		return bRet;
	}
}
