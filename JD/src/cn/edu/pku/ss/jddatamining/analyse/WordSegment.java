package JDAnalysis;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class WordSegment 
{
	String dir_exe="";
	String arg1="";
	String arg2="";
	
	
	
	public WordSegment()
	{
		dir_exe="C:\\Users\\guicun\\workspace\\wangguicun\\bin\\Segment\\devidewords.exe";
		arg1=" C:\\Users\\guicun\\workspace\\wangguicun\\bin\\Segment\\pangu\\PanGu.xml ";
		arg2="";
	}
	
	@SuppressWarnings("finally")
	public String ExecuteWordSegmentation()
	{
		String lineStr="#";  
		try 
		{ 
			Process p;
		
//			arg2="开始 nihao \t我是";
			arg2=arg2.replaceAll(" ", "");
			arg2=arg2.replaceAll("\t", "");
			String cmd=dir_exe+arg1+arg2;
			p=java.lang.Runtime.getRuntime().exec(cmd); 
		
			BufferedInputStream br = new BufferedInputStream(p.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(br));  
			
			lineStr = inBr.readLine();
			inBr.close();
			br.close();
			p.destroy();
			return lineStr;
//			String []segresult=lineStr.split("-");
//			strResult=segresult[0];
//			if(segresult[0].length()<2) strResult=segresult[0]+segresult[1];
//			else if(segresult[0].length()==2&&segresult[1].length()<2) strResult=segresult[0]+segresult[1];
		} catch (IOException e) 
		{ 
			System.out.println("分词程序错误");
			e.printStackTrace(); 
		} finally
		{
			return lineStr;
		}
	}
}
