package cn.edu.pku.ss.jddatamining.analyse;
import java.io.*;
public class WordSegment 
{
	String dir_exe="";
	String arg1="";
	String arg2="";
	
	String strResult="#";
	
	public WordSegment()
	{
		dir_exe="C:\\Users\\guicun\\workspace\\wangguicun\\bin\\Segment\\devidewords.exe";
		arg1=" C:\\Users\\guicun\\workspace\\wangguicun\\bin\\Segment\\pangu\\PanGu.xml ";
		arg2="";
	}
	
	@SuppressWarnings("finally")
	public String ExecuteWordSegmentation()
	{
		try 
		{ 
			Process p;
			String cmd=dir_exe+arg1+arg2;
			p=java.lang.Runtime.getRuntime().exec(cmd); 
		
			BufferedInputStream br = new BufferedInputStream(p.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(br));  
			String lineStr=null;  
			lineStr = inBr.readLine();
			inBr.close();
			br.close();
			
			String []segresult=lineStr.split("-");
			strResult=segresult[0];
			if(segresult[0].length()<2) strResult=segresult[0]+segresult[1];
			else if(segresult[0].length()==2&&segresult[1].length()<2) strResult=segresult[0]+segresult[1];
		} catch (IOException e) 
		{ 
			System.out.println("·Ö´Ê³ÌÐò´íÎó");
			e.printStackTrace(); 
		} finally
		{
			return strResult;
		}
	}
}
