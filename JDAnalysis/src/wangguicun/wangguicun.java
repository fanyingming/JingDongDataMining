package wangguicun;
import java.util.*;
import java.sql.SQLException;

public class wangguicun {
	static WordSegment wseg=new WordSegment();
	static UseDatabase udb=new UseDatabase();
	static String strPrint="";
	static HashMap<String, Integer> ht;
	public static void main(String[] args) throws SQLException {
		udb.InitDatabase();
		ht=new HashMap<String, Integer>();
		while(true)	
		{
			String info_product=udb.GetNextProductInfo();
			if(info_product=="#") break;
			String []info=info_product.split("&");
			
//			info[0]="【100%直供机100A】100%直供机 100A 电信3G手机（珍珠白）";
			int ipos=info[0].indexOf("【");
			int epos=info[0].indexOf("】");
			String str;
			if(ipos!=-1&&epos!=-1)
			{
				str=info[0].substring(ipos, epos+1);
				info[0]=info[0].replace(str, "");
			}
			ipos=info[0].indexOf("【");
			epos=info[0].indexOf("】");
			if(ipos!=-1&&epos!=-1)
			{
				str=info[0].substring(ipos, epos+1);
				info[0]=info[0].replace(str, "");
			}
//			String []content=info[0].split("[^\u4e00-\u9fa5]");
			String []content=info[0].split("[^A-Za-z\\u4e00-\\u9fa5]");
		     for(int i=0;i<content.length;i++)
		     {
		    	 if(content[i].length()>0)
		    	 {
		    		 strPrint=content[i];
//		    		 if(strPrint.ma)
		    		 if(content[i].length()>4)
		    		 {
		    			 wseg.arg2=content[i];
		            	 String srtResult=wseg.ExecuteWordSegmentation();
		            	 strPrint=srtResult;
		    		 }
		    		 break;
		    	 }
		     }		     
		     if(ht.containsKey(strPrint)==false) ht.put(strPrint, 1);
		     else 
		     {
		    	 int temp=ht.get(strPrint);
		    	 temp++;
		    	 ht.remove(strPrint);
		    	 ht.put(strPrint, temp);
		     }
		     System.out.println(strPrint+info[1]);
		}
		System.out.println(ht.size());
		udb.ShutDownDatabase();
	
 }
      

}
