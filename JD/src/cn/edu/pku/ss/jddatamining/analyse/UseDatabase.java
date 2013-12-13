package cn.edu.pku.ss.jddatamining.analyse;

import cn.edu.pku.ss.jddatamining.util.GlobalData;;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseDatabase {
	 String user = GlobalData.DBUserName;
	 String password = GlobalData.DBPassword;
	 String url = "jdbc:mysql://localhost:3306/jdcrawler";
	 String driver = "com.mysql.jdbc.Driver";
	 String tableName = "items";
	 String sqlstr;
	 Connection con = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	public void InitDatabase()
	{
		 try
		 {
	         Class.forName(driver);
	         con = DriverManager.getConnection(url, user, password);
	         stmt = con.createStatement();  
	         sqlstr = "select * from "+tableName;
	         rs = stmt.executeQuery(sqlstr);       
		 }
         catch(ClassNotFoundException e1)
         {
             System.out.println("数据库驱动不存在！");
             System.out.println(e1.toString());
         }
         catch(SQLException e2)
         {
             System.out.println("数据库存在异常！");
             System.out.println(e2.toString());
         }
	}
	public String GetNextProductInfo() throws SQLException
	{
		if(rs.next()) 
			{
				String temp = "#";
				for(int i=5;i<25;i++)
				{
					if(rs.getString(i).length()<1) temp=temp+"无"+"#";
					else temp=temp+rs.getString(i)+"#";
				}
				return temp;
			}
		else return "#";
	}
	public void SetProductInfo() throws SQLException
	{
		
	}
	public void ShutDownDatabase()
	{
		  try
          {
              if(rs != null) rs.close();
              if(stmt != null) stmt.close();
              if(con != null) con.close();
          }
          catch(SQLException e)
          {
         	 System.out.println("数据库存在异常!");
              System.out.println(e.toString());
          } 
	}
}
