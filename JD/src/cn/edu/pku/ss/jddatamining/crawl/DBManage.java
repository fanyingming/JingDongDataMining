package cn.edu.pku.ss.jddatamining.crawl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import cn.edu.pku.ss.jddatamining.util.GlobalData;
public class DBManage {
	private String host = GlobalData.DBHost;
	private String user = GlobalData.DBUserName;
	private String pwd = GlobalData.DBPassword;
	private String schema = GlobalData.DBName;
	
	public DBManage(){
	}
	public DBManage(String host,String user,String pwd, String schema){
		this.host = host;
		this.user =  user;
		this.pwd = pwd;
		this.schema = schema;
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://" + this.host + ":3306/" + this.schema + "?autoReconnect=true&UseUnicode=true&"
							+ "characterEncoding=utf8", this.user, this.pwd);
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
	public Connection getConnection_schema() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://" + this.host + ":3306/?autoReconnect=true&UseUnicode=true&"
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
 	public Connection initTable_items() {
		Connection conn = getConnection();
		// 如果不存在数据库则新建数据库,建立相应的表
		try {
			Statement stmt = conn.createStatement();
			String createTable = "CREATE TABLE IF NOT EXISTS `items` ( "
					+ "`itemUrl` varchar(400) DEFAULT NULL, "
					+ "`itemUrlMD5` varchar(80) NOT NULL, "
					+ "`detailUrl` varchar(400) DEFAULT NULL, "
					+ "`commentUrl` varchar(400) DEFAULT NULL, "
					+ "`price` double DEFAULT NULL, "
					+ "`title` varchar(400) DEFAULT NULL, "
					+ "`brand` varchar(45) DEFAULT NULL, "
					+ "`model` varchar(45) DEFAULT NULL, "
					+ "`color` varchar(45) DEFAULT NULL, "
					+ "`platform` varchar(45) DEFAULT NULL, "
					+ "`os` varchar(45) DEFAULT NULL, "
					+ "`cpuType` varchar(100) DEFAULT NULL, "
					+ "`ram` varchar(100) DEFAULT NULL,"
					+ " `hardDrive` varchar(100) DEFAULT NULL, "
					+ "`cdRom` varchar(45) DEFAULT NULL, "
					+ "`monitor` varchar(200) DEFAULT NULL, "
					+ "`weight` varchar(45) DEFAULT NULL, "
					+ "`size` varchar(400) DEFAULT NULL, "
					+ "`isDetailAnalyzed` int(11) DEFAULT NULL, "
					+ "`isCommentAnalyzed` int(11) DEFAULT NULL, "
					+ "`goodCommentNum` int(11) DEFAULT NULL, "
					+ "`mediumCommentNum` int(11) DEFAULT NULL, "
					+ "`badCommentNum` varchar(45) DEFAULT NULL, "
					+ "`commentContent` varchar(5000) default NULL,"
					+ "PRIMARY KEY (`itemUrlMD5`))" + "ENGINE=InnoDB "
					+ "DEFAULT CHARSET=utf8";
			stmt.execute(createTable);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果存在数据库则直接返回数据库连接
		return conn;
	}
	public Connection initTable_urls( String srcURL) {
		Connection conn = getConnection();
		// 如果不存在数据库则新建数据库,建立相应的表
		try {
			Statement stmt = conn.createStatement();
			String createTable = "CREATE TABLE IF NOT EXISTS `urls` ( `UrlMD5` varchar(80) NOT NULL, `Url` varchar(400) DEFAULT NULL, `Depth` int(11) DEFAULT NULL, `IsAnalyzed` int(11) DEFAULT NULL, `InsertTime` datetime DEFAULT NULL, PRIMARY KEY (`UrlMD5`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
			stmt.execute(createTable);
			String srcUrlMD5 = EncryptionByMD5.getMD5(srcURL);
			String addSrcUrl = "insert ignore into urls (Url,UrlMD5,Depth,IsAnalyzed,InsertTime) values ('"
					+ srcURL + "','" + srcUrlMD5 + "',0,0,now())";
			stmt.executeUpdate(addSrcUrl);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果存在数据库则直接返回数据库连接
		return conn;
	}
	public boolean closeDB(Connection conn) {
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
	
	public boolean createSchema(){
		boolean bRet = false;
		try {
			Connection conn = getConnection_schema();
			Statement stmt = conn.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS `" + this.schema
					+ "` DEFAULT CHARACTER SET utf8 ;";
			stmt.execute(sql);
			bRet = true;
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bRet;
	}
	public boolean initDB(String srcURL){
		boolean bRet  = false;
		createSchema();
		initTable_urls(srcURL);
		initTable_items();
		return bRet;
	}
}
