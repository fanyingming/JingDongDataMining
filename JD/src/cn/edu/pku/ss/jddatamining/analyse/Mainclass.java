package cn.edu.pku.ss.jddatamining.analyse;
import java.text.DecimalFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import cn.edu.pku.ss.jddatamining.util.GlobalData;

public class Mainclass 
{
	static WordSegment wseg=new WordSegment();
	static UseDatabase udb=new UseDatabase();
	static String strPrint="";
	static HashMap<String, Analysis_base_brand> ht;
	static HashMap<String, Analysis_base_brand> hms;
	static Analysis_base_price []Anaprice=new Analysis_base_price[6];
	static Analysis_base_CPU[] AnaCPU=new Analysis_base_CPU[7];
	public static void main(String[] args) throws SQLException, IOException
	{
		analyse();
		
	}
	public static void analyse() throws SQLException, IOException 
	{
		udb.InitDatabase();
		for(int i=0;i<6;i++) Anaprice[i]=new Analysis_base_price();
		for(int i=0;i<7;i++) AnaCPU[i]=new Analysis_base_CPU();
		ht=new HashMap<String, Analysis_base_brand>();
		hms=new HashMap<String, Analysis_base_brand>();
		while(true)	
		{
			String info_product=udb.GetNextProductInfo();
			if(info_product=="#") break;
			String []info=info_product.split("#");
			ComputerInfo computer=new ComputerInfo();
			String []content=info[3].split("[^A-Za-z\\u4e00-\\u9fa5]");		
			computer.Brand=content[0];
			if(computer.Brand.equals("HP")) 
			{
				computer.Brand="惠普";
			}
			if(computer.Brand.equals("技嘉GITABYTE")) 
			{			
				computer.Brand="技嘉";
			}
			if(info[2].contains("Thinkpad")||info[2].contains("ThinkPad")) 
			{			
				computer.Brand="Thinkpad";
			}
			computer.Price=info[1];
			computer.Platform=info[6];
			computer.OS=info[7];
			computer.CPU=info[8];
			computer.Ram=info[9];
			computer.Harddrive=info[10];
			if(info[12].equals("null")) computer.Size="else";
			else if(info[12].length()>=2)
			{
				computer.Size=info[12].substring(0, 2);
				if(computer.Size.equals("雾面")) computer.Size="0";
			}
			
			else computer.Size="0";
			computer.Weight=info[13];
			computer.Goodcomment=info[17];
			computer.Mediacomment=info[18];
			computer.Badcomment=info[19];
			computer.Comment=info[20];
			Analysis_base_brand aninfo=new Analysis_base_brand();
			aninfo.brand=computer.Brand;
			aninfo.price=Integer.parseInt(computer.Price);
			aninfo.modelamount=1;
			aninfo.good=Integer.parseInt(computer.Goodcomment);
			aninfo.bad=Integer.parseInt(computer.Badcomment);
			aninfo.middle=Integer.parseInt(computer.Mediacomment);
			aninfo.sellamount=aninfo.good+aninfo.bad+aninfo.middle;
			aninfo.comment=computer.Comment;
	
			AnalysisBasePrice(aninfo,computer);
			AnalysisBaseBrand( aninfo, computer);
			AnalysisBaseCPU( aninfo, computer);
			AnalysisBaseSize( aninfo, computer);
		}		
			
		PrintResultBasePrice();
		PrintResultBaseBrand();
		PrintResultBaseCPU();
		PrintResultBaseSize();
		udb.ShutDownDatabase();
	
 }
static void AnalysisBaseSize(Analysis_base_brand aninfo,ComputerInfo computer)
{
	
	if(hms.containsKey(computer.Size)==false) hms.put(computer.Size, aninfo);
	else{
		 Analysis_base_brand temp=hms.get(computer.Size);
		 temp.price+=aninfo.price;
		 temp.sellamount+=aninfo.sellamount;
		 temp.modelamount+=aninfo.modelamount;
		 
		 hms.remove(computer.Size);
		 hms.put(computer.Size, temp);
	}
	
}
static void PrintResultBaseSize() throws IOException
{
	Iterator iter = hms.entrySet().iterator();
	System.out.println("尺寸\t型号数量\t销量\t该尺寸型号百分比\t平均价格");
	FileWriter writer=new FileWriter(GlobalData.ProjacePath+"\\"+"statistics_base_Size.txt");
	String strPrint="尺寸,型号数量,销量,该尺寸型号百分比,平均价格;\n";
     while(iter.hasNext())
     {
    	 	DecimalFormat df = new DecimalFormat("#.###");    
            Map.Entry entry = (Map.Entry)iter.next();
            String  key = (String)entry.getKey(); 
            System.out.print(key+"\t");
            strPrint+=key+",";
            Analysis_base_brand info_print = (Analysis_base_brand)entry.getValue();
            System.out.print(info_print.modelamount+"\t");
            strPrint+=info_print.modelamount+",";
            System.out.print(info_print.sellamount+"\t");
            strPrint+=info_print.sellamount+",";
            String result=df.format((float)(info_print.modelamount/8.07));
            System.out.print(result+"%\t");
            strPrint+=result+"%,";
            System.out.print((float)info_print.price/info_print.modelamount+"\n");
            strPrint+=(float)info_print.price/info_print.modelamount+";\n";
     }
     
     try {
         writer.write(strPrint);
         writer.flush();
         writer.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
     
     
     
}
static void AnalysisBaseCPU(Analysis_base_brand aninfo,ComputerInfo computer)	
{
	String m_CPU=computer.CPU;
	
	if(m_CPU.contains("A4"))
	{
		AnaCPU[0].xinghao="AMD A4";
		AnaCPU[0].sellamount+=aninfo.sellamount;
		AnaCPU[0].modelamount+=aninfo.modelamount;
		AnaCPU[0].price+=aninfo.price;
	}
	if(m_CPU.contains("A6"))
	{
		AnaCPU[1].xinghao="AMD A6";
		AnaCPU[1].sellamount+=aninfo.sellamount;
		AnaCPU[1].modelamount+=aninfo.modelamount;
		AnaCPU[1].price+=aninfo.price;
	}
	if(m_CPU.contains("A8"))
	{
		AnaCPU[2].xinghao="AMD A8";
		AnaCPU[2].sellamount+=aninfo.sellamount;
		AnaCPU[2].modelamount+=aninfo.modelamount;
		AnaCPU[2].price+=aninfo.price;
	}
	if(m_CPU.contains("A10"))
	{
		AnaCPU[3].xinghao="AMD A10";
		AnaCPU[3].sellamount+=aninfo.sellamount;
		AnaCPU[3].modelamount+=aninfo.modelamount;
		AnaCPU[3].price+=aninfo.price;
	}
	if(m_CPU.contains("A10"))
	{
		AnaCPU[3].xinghao="AMD A10";
		AnaCPU[3].sellamount+=aninfo.sellamount;
		AnaCPU[3].modelamount+=aninfo.modelamount;
		AnaCPU[3].price+=aninfo.price;
	}
	if(m_CPU.contains("i3")||m_CPU.contains("I3"))
	{
		AnaCPU[4].xinghao="Intel i3";
		AnaCPU[4].sellamount+=aninfo.sellamount;
		AnaCPU[4].modelamount+=aninfo.modelamount;
		AnaCPU[4].price+=aninfo.price;
	}
	if(m_CPU.contains("i5")||m_CPU.contains("I5"))
	{
		AnaCPU[5].xinghao="Intel i5";
		AnaCPU[5].sellamount+=aninfo.sellamount;
		AnaCPU[5].modelamount+=aninfo.modelamount;
		AnaCPU[5].price+=aninfo.price;
	}
	if(m_CPU.contains("i7")||m_CPU.contains("I7"))
	{
		AnaCPU[6].xinghao="Intel i7";
		AnaCPU[6].sellamount+=aninfo.sellamount;
		AnaCPU[6].modelamount+=aninfo.modelamount;
		AnaCPU[6].price+=aninfo.price;
	}
	
}
	
static void PrintResultBaseCPU() throws IOException
{	
	System.out.println("CPU型号\t型号数量\t销量\t平均售价");
	FileWriter writer=new FileWriter(GlobalData.ProjacePath+"\\"+"statistics_base_CPU.txt");
	String strPrint="CPU型号,型号数量,销量,平均售价;\n";
	for(int i=0;i<7;i++)
	{
		System.out.print(AnaCPU[i].xinghao+"\t");
		strPrint+=AnaCPU[i].xinghao+",";
		System.out.print(AnaCPU[i].modelamount+"\t");
		strPrint+=AnaCPU[i].modelamount+",";
		System.out.print(AnaCPU[i].sellamount+"\t");
		strPrint+=AnaCPU[i].sellamount+",";
		float aveprice=AnaCPU[i].price/AnaCPU[i].modelamount;
		System.out.println(aveprice+"");
		strPrint+=aveprice+";\n";
	}
  try {
         writer.write(strPrint);
         writer.flush();
         writer.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
	
	
}
static void AnalysisBasePrice(Analysis_base_brand aninfo,ComputerInfo computer)
{
	if(aninfo.price<=3000)
	{
		Anaprice[0].qujian="3000以下";
		Anaprice[0].sellamount+=aninfo.sellamount;
		if(Anaprice[0].hmp.containsKey(computer.Brand)==false) Anaprice[0].hmp.put(computer.Brand, aninfo);
		  else 
		     {
		    	 Analysis_base_brand temp=Anaprice[0].hmp.get(computer.Brand);
		    	 temp.bad+=aninfo.bad;
		    	 temp.good+=aninfo.good;
		    	 temp.middle+=aninfo.middle;
		    	 temp.price+=aninfo.price;
		    	 temp.modelamount+=1;
		    	 temp.sellamount+=aninfo.sellamount;
		    	 Anaprice[0].hmp.remove(computer.Brand);
		    	 Anaprice[0].hmp.put(computer.Brand, temp);
		     }
	}
	else if(aninfo.price<=5000)
	{
		Anaprice[1].qujian="3000-5000";
		Anaprice[1].sellamount+=aninfo.sellamount;
		if(Anaprice[1].hmp.containsKey(computer.Brand)==false) Anaprice[1].hmp.put(computer.Brand, aninfo);
		  else 
		     {
		    	 Analysis_base_brand temp=Anaprice[1].hmp.get(computer.Brand);
		    	 temp.bad+=aninfo.bad;
		    	 temp.good+=aninfo.good;
		    	 temp.middle+=aninfo.middle;
		    	 temp.price+=aninfo.price;
		    	 temp.modelamount+=1;
		    	 temp.sellamount+=aninfo.sellamount;
		    	 Anaprice[1].hmp.remove(computer.Brand);
		    	 Anaprice[1].hmp.put(computer.Brand, temp);
		     }
	}
	else if(aninfo.price<=8000)
	{
		Anaprice[2].qujian="5000-8000";
		Anaprice[2].sellamount+=aninfo.sellamount;
		if(Anaprice[2].hmp.containsKey(computer.Brand)==false) Anaprice[2].hmp.put(computer.Brand, aninfo);
		  else 
		     {
		    	 Analysis_base_brand temp=Anaprice[2].hmp.get(computer.Brand);
		    	 temp.bad+=aninfo.bad;
		    	 temp.good+=aninfo.good;
		    	 temp.middle+=aninfo.middle;
		    	 temp.price+=aninfo.price;
		    	 temp.modelamount+=1;
		    	 temp.sellamount+=aninfo.sellamount;
		    	 Anaprice[2].hmp.remove(computer.Brand);
		    	 Anaprice[2].hmp.put(computer.Brand, temp);
		     }
	}
	else if(aninfo.price<=15000)
	{
		Anaprice[3].qujian="8000-15000";
		Anaprice[3].sellamount+=aninfo.sellamount;
		if(Anaprice[3].hmp.containsKey(computer.Brand)==false) Anaprice[3].hmp.put(computer.Brand, aninfo);
		  else 
		     {
		    	 Analysis_base_brand temp=Anaprice[3].hmp.get(computer.Brand);
		    	 temp.bad+=aninfo.bad;
		    	 temp.good+=aninfo.good;
		    	 temp.middle+=aninfo.middle;
		    	 temp.price+=aninfo.price;
		    	 temp.modelamount+=1;
		    	 temp.sellamount+=aninfo.sellamount;
		    	 Anaprice[3].hmp.remove(computer.Brand);
		    	 Anaprice[3].hmp.put(computer.Brand, temp);
		     }
	}
	else if(aninfo.price<=30000)
	{
		Anaprice[4].qujian="15000-30000";
		Anaprice[4].sellamount+=aninfo.sellamount;
	
		if(Anaprice[4].hmp.containsKey(computer.Brand)==false) 
		{
			

			Anaprice[4].hmp.put(computer.Brand, aninfo);
		}
		  else 
		     {
	
		    	 Analysis_base_brand temp=Anaprice[4].hmp.get(computer.Brand);
		    	 temp.bad+=aninfo.bad;
		    	 temp.good+=aninfo.good;
		    	 temp.middle+=aninfo.middle;
		    	 temp.price+=aninfo.price;
		    	 temp.modelamount+=1;
		    	 temp.sellamount+=aninfo.sellamount;
		    	 Anaprice[4].hmp.remove(computer.Brand);
		    	 Anaprice[4].hmp.put(computer.Brand, temp);
		     }
	}
	else if(aninfo.price>30000)
	{
		Anaprice[5].qujian="30000以上";
		Anaprice[5].sellamount+=aninfo.sellamount;

		if(Anaprice[5].hmp.containsKey(computer.Brand)==false) Anaprice[5].hmp.put(computer.Brand, aninfo);
		  else 
		     {
		    	 Analysis_base_brand temp=Anaprice[5].hmp.get(computer.Brand);
		    	 temp.bad+=aninfo.bad;
		    	 temp.good+=aninfo.good;
		    	 temp.middle+=aninfo.middle;
		    	 temp.price+=aninfo.price;
		    	 temp.modelamount+=1;
		    	 temp.sellamount+=aninfo.sellamount;
		    	 Anaprice[5].hmp.remove(computer.Brand);
		    	 Anaprice[5].hmp.put(computer.Brand, temp);
		     }
	}
//     if(ht.containsKey(computer.Brand)==false) ht.put(computer.Brand, aninfo);
//     else 
//     {
//    	 Analysis_base_brand temp=ht.get(computer.Brand);
//    	 temp.bad+=aninfo.bad;
//    	 temp.good+=aninfo.good;
//    	 temp.middle+=aninfo.middle;
//    	 temp.price+=aninfo.price;
//    	 temp.modelamount+=1;
//    	 temp.sellamount+=aninfo.sellamount;
//    	 
//    	 ht.remove(computer.Brand);
//    	 ht.put(computer.Brand, temp);
//     }

}
static void PrintResultBasePrice() throws IOException
{	
	System.out.println("价格区间\t销量\t品牌分布");
	FileWriter writer=new FileWriter(GlobalData.ProjacePath+"\\"+"statistics_base_price.txt");
	String strPrint=new String();
	strPrint="价格区间,销量,品牌分布;\n";
	for(int i=0;i<6;i++)
	{
		System.out.print(Anaprice[i].qujian);
		strPrint+=Anaprice[i].qujian+","+Anaprice[i].sellamount+",";
		System.out.print("\t");
		System.out.print(Anaprice[i].sellamount);
		System.out.print("\t");
		Iterator iter = Anaprice[i].hmp.entrySet().iterator();
		 while(iter.hasNext())
	     {
	            Map.Entry entry = (Map.Entry)iter.next();
	            String  key = (String)entry.getKey(); 
	            System.out.print(key+"\t");
	            strPrint+=key+",";
	            Analysis_base_brand info_print = (Analysis_base_brand)entry.getValue();
	            DecimalFormat df = new DecimalFormat("#.#####"); 
	            System.out.print(df.format(((float)info_print.sellamount/Anaprice[i].sellamount)));
	            strPrint+=df.format(((float)info_print.sellamount/Anaprice[i].sellamount))+",";
	            System.out.print("\t");
		}
		 strPrint+=";\n";
		 System.out.println("");
	}
	
	  try {
	         writer.write(strPrint);
	         writer.flush();
	         writer.close();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	
	
	
}
static void AnalysisBaseBrand(Analysis_base_brand aninfo,ComputerInfo computer)
{
	if(ht.containsKey(computer.Brand)==false)ht.put(computer.Brand, aninfo);
	  else 
	     {
	    	 Analysis_base_brand temp=ht.get(computer.Brand);
	    	 temp.bad+=aninfo.bad;
	    	 temp.good+=aninfo.good;
	    	 temp.middle+=aninfo.middle;
	    	 temp.price+=aninfo.price;
	    	 temp.modelamount+=1;
	    	 temp.sellamount+=aninfo.sellamount;
	    	 temp.comment+=aninfo.comment;
//	    	 wseg.arg2=temp.comment;
//        	 String srtResult=wseg.ExecuteWordSegmentation();
//	    	 String []words=srtResult.split("-");
//        	 
//	    	 for(int i=0;i<words.length;i++)
//	    	 {
//	    		 if(temp.hmb.containsKey(words[i])==false) temp.hmb.put(words[i], 1);
//	    		 else 
//	    		     {
//	    			 	int number=temp.hmb.get(words[i]);
//	    			 	number++;
//	    			 	temp.hmb.remove(words[i]);
//	    			 	temp.hmb.put(words[i], number);  	
//	    		     }
//	    		 
//	    	 }
	    	 ht.remove(computer.Brand);
	    	 ht.put(computer.Brand, temp);
	    	 
	     }
}
static void PrintResultBaseBrand() throws IOException
{
	Iterator iter = ht.entrySet().iterator();
	System.out.println("品牌\t型号数量\t平均价格\t销量\t销量百分比\t好评度\t");
	FileWriter writer=new FileWriter(GlobalData.ProjacePath+"\\"+"statistics_base_brand.txt");
	String strPrint="品牌,型号数量,平均价格,销量,销量百分比,好评度;\n";
     while(iter.hasNext())
     {
            Map.Entry entry = (Map.Entry)iter.next();
            String  key = (String)entry.getKey(); 
            System.out.print(key+"\t");
            strPrint+=key+",";
            
            Analysis_base_brand info_print = (Analysis_base_brand)entry.getValue();
            System.out.print((info_print.modelamount));
            strPrint+=info_print.modelamount+",";
            System.out.print("\t");
            System.out.print((double)(info_print.price/info_print.modelamount));
            strPrint+=(double)(info_print.price/info_print.modelamount)+",";
            System.out.print("\t");
            
            System.out.print((info_print.sellamount));
            strPrint+=info_print.sellamount+",";
            System.out.print("\t");
            DecimalFormat df = new DecimalFormat("#.###");    
            float result=(float)(info_print.sellamount/1625.85);
            
            System.out.print(df.format(result)+"%\t");
            strPrint+=df.format(result)+"%,";
            System.out.print(((float)info_print.good/info_print.sellamount));
            strPrint+=df.format((float)info_print.good/info_print.sellamount)+"";
            System.out.print("\n");
            strPrint+=";\n";
            
            FileWriter writer2=new FileWriter(GlobalData.ProjacePath+"\\"+"keywords_base_brand.txt");
        	String strPrint2="品牌,型号数量,平均价格,销量,销量百分比,好评度;\n";
//          wseg.arg2=info_print.comment;
//          if(wseg.arg2.length()>10000) wseg.arg2=wseg.arg2.substring(0, 10000);
//     	 	String srtResult=wseg.ExecuteWordSegmentation();
//	    	String []words=srtResult.split("-");
//	    	HashMap<String, Integer> hmb;
//	    	hmb=new HashMap<String, Integer>();
//	    	String symbol="总结 电脑 本本 这款 就是 还是 自己 但是 这个 那个 是用 只是 笔记本 东西 感觉 可以 这些 尤其 总体 有点 没有 哈哈 其他";
//	    	String []symbolwords=symbol.split(" ");
//	    	 for(int i=0;i<words.length;i++)
//	    	 {
//	    		 if(words[i].length()<2) continue;
//	    		 boolean isValidword=true;
//	    		 for(int j=0;j<symbolwords.length;j++)
//	    			 {
//	    			 	String w=words[i];
//	    			 	String s=symbolwords[j];
//	    			 	if(words[i].equals(symbolwords[j])) 
//	    			 		{
//	    			 			isValidword=false;
//	    			 		}
//	    			 }
//	    		 if(!isValidword) continue;
//	    		 if(hmb.containsKey(words[i])==false) hmb.put(words[i], 1);
//	    		 else 
//	    		     {
//	    			 	int number=hmb.get(words[i]);
//	    			 	number++;
//	    			 	hmb.remove(words[i]);
//	    			 	hmb.put(words[i], number);  	
//	    		     }
//	    	 }
//          
//	    	 ByValueComparator bvc = new ByValueComparator(hmb);
//	    	  
//	    	  //第一种方法
//	    	  TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
//	    	  sorted_map.putAll(hmb);
//	    	  int num=0;
//	    	  for(String name : sorted_map.keySet()){
//	    	   System.out.printf("%s\t->\t%d\n", name, hmb.get(name));
//	    	   num++;
//	    	   if(num>=10) break;
//	    	  }
          
          
//          System.out.println(value);
	}
	
     try {
         writer.write(strPrint);
         writer.flush();
         writer.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
     
	System.out.println(ht.size());
	ht.clear();
}
	
	
      

}
class ByValueComparator implements Comparator<String> {
	HashMap<String, Integer> base_map;

	public ByValueComparator(HashMap<String, Integer> base_map) {
		this.base_map = base_map;
	}

	public int compare(String arg0, String arg1) {
		if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
			return 0;
		}

		if (base_map.get(arg0) < base_map.get(arg1)) {
			return 1;
		} else if (base_map.get(arg0) == base_map.get(arg1)) {
			return 0;
		} else {
			return -1;
		}
	}
}