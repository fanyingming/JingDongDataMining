package cn.edu.pku.ss;

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
		// 如果不存在数据库则新建数据库,建立相应的表
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
		// 如果存在数据库则直接返回数据库连接
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
			System.out.println(" 开始读:" + url);
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
				'a', 'b', 'c', 'd', 'e', 'f' };// 用来将字节转换成16进制表示的字符
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest();// MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
			// 进制需要 32 个字符
			int k = 0;// 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
				// 进制字符的转换
				byte byte0 = tmp[i];// 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
				// 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换
			}
			s = new String(str);// 换后的结果转换为字符串
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return s;
	}
}