package cn.edu.pku.ss.jddatamining.analyse;
import java.sql.*;
public class UseDatabase {
	 String user = "root";
	 String password = "wangguicun";
	 String url = "jdbc:mysql://localhost:3306/jdcrawler";
	 String driver = "com.mysql.jdbc.Driver";
	 String tableName = "results";
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
		if(rs.next()) return rs.getString(3)+"&"+rs.getString(4);
		else return "#";
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
