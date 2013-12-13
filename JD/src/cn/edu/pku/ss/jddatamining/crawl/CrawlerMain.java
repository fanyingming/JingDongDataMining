package cn.edu.pku.ss.jddatamining.crawl;

import java.io.IOException;

public class CrawlerMain {
	public static void main(String[] args) throws IOException {
		String srcUrl = "http://list.jd.com/9987-653-655-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-33.html";
		int threadNum = 4;
//		Spider spider = new Spider(srcUrl, threadNum);
//		spider.Start();
		WebPageAnalyzer onePage = new WebPageAnalyzer();
		onePage.Start();
	}
}
