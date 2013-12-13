package cn.edu.pku.ss.jddatamining.crawl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
	private String srcURL;
	private int threadNum;

	public Spider(String srcUrl, int threadNum) {
		this.srcURL = srcUrl;
		this.threadNum = threadNum;
	}

	private Connection initDB() {
		Connection conn = Spider.getConnection();
		// 濡傛灉涓嶅瓨鍦ㄦ暟鎹簱鍒欐柊寤烘暟鎹簱,寤虹珛鐩稿簲鐨勮〃
		try {
			Statement stmt = conn.createStatement();
			String createTable = "CREATE TABLE IF NOT EXISTS `urls` ( `UrlMD5` varchar(80) NOT NULL, `Url` varchar(400) DEFAULT NULL, `Depth` int(11) DEFAULT NULL, `IsAnalyzed` int(11) DEFAULT NULL, `InsertTime` datetime DEFAULT NULL, PRIMARY KEY (`UrlMD5`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
			stmt.execute(createTable);
			String srcUrlMD5 = EncryptionByMD5.getMD5(this.srcURL);
			String addSrcUrl = "insert ignore into urls (Url,UrlMD5,Depth,IsAnalyzed,InsertTime) values ('"
					+ this.srcURL + "','" + srcUrlMD5 + "',0,0,now())";
			stmt.executeUpdate(addSrcUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 濡傛灉瀛樺湪鏁版嵁搴撳垯鐩存帴杩斿洖鏁版嵁搴撹繛鎺�
		return conn;
	}

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdcrawler?autoReconnect=true&UseUnicode=true&"
							+ "characterEncoding=utf8", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private boolean closeDB(Connection conn) {
		boolean bRet = false;
		try {
			if (conn != null) {
				conn.close();
				bRet = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bRet;
	}

	public void Start() throws IOException {
		Connection conn = initDB();
		try {
			while (true) {
				String url = getSrcUrl(conn);
				if (url != "" && url != null) {
					crawlOnePage(url, conn);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB(conn);
		}
	}

	private String getSrcUrl(Connection conn) {
		String url = "";
		String srcUrl = "select url from urls where depth = 0 and IsAnalyzed = 0 order by InsertTime limit 1";
		try {
			Statement stmt = conn.createStatement();
			ResultSet row = stmt.executeQuery(srcUrl);
			if (row.next()) {
				url = row.getString("Url");
			}
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bRet;
	}

	public static Document getWebPage(String url) {
		Document document = null;
		try {
			System.out.println(" 寮�璇�" + url);
			URL uurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) uurl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty(
					"User-Agent",
					"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");
			conn.setConnectTimeout(40000);
			conn.setReadTimeout(40000);

			InputStream inputStream = conn.getInputStream();
			document = Jsoup.parse(inputStream, "gbk", url);

			conn.disconnect();
		} catch (MalformedURLException e) {
			System.out.println(" 鑾峰彇缃戦〉闂鎶ラ敊");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(" 鑾峰彇缃戦〉鎶ラ敊");
			e.printStackTrace();
		}
		return document;
	}

	private HashMap<String, Integer> ExtractUrls(Document doc) {
		HashMap<String, Integer> urls = new HashMap<String, Integer>();
		String itemSelect = "ul.list-h>li>div.p-name>a[href]";
		Elements itemUrls = doc.select(itemSelect);
		for (Element item : itemUrls) {
			String url = item.attr("abs:href");
			urls.put(url, 1);
		}
		// page urls:depth = 0
		String pageSelect = "div.pagin.fr>a[href]";
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
		return bRet;
	}
}

class EncryptionByMD5 {
	public static String getMD5(String src) {
		byte[] source = src.getBytes();
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };// 鐢ㄦ潵灏嗗瓧鑺傝浆鎹㈡垚16杩涘埗琛ㄧず鐨勫瓧绗�
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest();// MD5 鐨勮绠楃粨鏋滄槸涓�釜 128 浣嶇殑闀挎暣鏁帮紝
			// 鐢ㄥ瓧鑺傝〃绀哄氨鏄�16 涓瓧鑺�
			char str[] = new char[16 * 2];// 姣忎釜瀛楄妭鐢�16 杩涘埗琛ㄧず鐨勮瘽锛屼娇鐢ㄤ袱涓瓧绗︼紝 鎵�互琛ㄧず鎴�16
			// 杩涘埗闇� 32 涓瓧绗�
			int k = 0;// 琛ㄧず杞崲缁撴灉涓搴旂殑瀛楃浣嶇疆
			for (int i = 0; i < 16; i++) {// 浠庣涓�釜瀛楄妭寮�锛屽 MD5 鐨勬瘡涓�釜瀛楄妭// 杞崲鎴�16
				// 杩涘埗瀛楃鐨勮浆鎹�
				byte byte0 = tmp[i];// 鍙栫 i 涓瓧鑺�
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 鍙栧瓧鑺備腑楂�4 浣嶇殑鏁板瓧杞崲,// >>>
				// 涓洪�杈戝彸绉伙紝灏嗙鍙蜂綅涓�捣鍙崇Щ
				str[k++] = hexDigits[byte0 & 0xf];// 鍙栧瓧鑺備腑浣�4 浣嶇殑鏁板瓧杞崲
			}
			s = new String(str);// 鎹㈠悗鐨勭粨鏋滆浆鎹负瀛楃涓�
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return s;
	}
}