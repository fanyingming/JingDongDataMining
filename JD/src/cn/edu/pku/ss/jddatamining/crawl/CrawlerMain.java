package cn.edu.pku.ss.jddatamining.crawl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CrawlerMain {
	static String srcUrl = "http://m.jd.com/products/670-671-672.html";
	static DBManage dbManager = new DBManage();
	static Spider spider = new Spider(srcUrl,dbManager);
	static ItemAnalyzer itemAnalyzer = new ItemAnalyzer(dbManager);
	static DetailAnalyzer detailAnalyzer = new DetailAnalyzer(dbManager);
	static CommentAnalyzer commentAnalyzer = new CommentAnalyzer(dbManager);
	
	public static void Crawl() throws IOException
	{
		//DBManage dbManager = new DBManage();
		//String srcUrl = "http://m.jd.com/products/670-671-672.html";
		dbManager.initDB(srcUrl);//初始化数据库经理
		//线程1：爬虫爬取笔记本链接
		//Spider spider = new Spider(srcUrl,dbManager);
		spider.start();
		//线程2：分析商品页面的详细信息和评论信息链接
		//ItemAnalyzer itemAnalyzer = new ItemAnalyzer(dbManager);
		itemAnalyzer.start();
		//线程3：分析商品的评论信息
		//CommentAnalyzer commentAnalyzer = new CommentAnalyzer(dbManager);
		commentAnalyzer.start();
		//线程4：分析商品的详细信息
		//DetailAnalyzer detailAnalyzer = new DetailAnalyzer(dbManager);
		detailAnalyzer.start();
	}
	public static void EndAllTasks() throws IOException
	{
		//DBManage dbManager = new DBManage();
		//String srcUrl = "http://m.jd.com/products/670-671-672.html";
		//dbManager.initDB(srcUrl);//初始化数据库经理
		//线程1：爬虫爬取笔记本链接
		//Spider spider = new Spider(srcUrl,dbManager);
		spider.stop();
		//线程2：分析商品页面的详细信息和评论信息链接
		//ItemAnalyzer itemAnalyzer = new ItemAnalyzer(dbManager);
		itemAnalyzer.stop();
		//线程3：分析商品的评论信息
		//CommentAnalyzer commentAnalyzer = new CommentAnalyzer(dbManager);
		commentAnalyzer.stop();
		//线程4：分析商品的详细信息
		//DetailAnalyzer detailAnalyzer = new DetailAnalyzer(dbManager);
		detailAnalyzer.stop();
	}
	public static void main(String[] args) throws IOException {
		Crawl();
	}
}
//utils:MD5
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
