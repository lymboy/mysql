package web.mysql.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtils
{
	private JDBCUtils() {}
	private static Connection con;
	
	static 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/day16";
			String usr = "root";
			String pwd = "123456";
			con = DriverManager.getConnection(url, usr, pwd);
			
		}
		catch (Exception e)
		{
			throw new RuntimeException(e + "连接失败");
		}
		
	}
	
	public static Connection getConnection()
	{
		return con;
	}
	
	public static void close(Connection con, Statement stmt)
	{
		if (stmt != null) {
			try {
				stmt.close();
			}
			catch (SQLException e)
			{ }
		}
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e)
			{ }
		}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet res)
	{
		if (res != null) {
			try {
				res.close();
			}
			catch (SQLException e)
			{ }
		}
		if (stmt != null) {
			try {
				stmt.close();
			}
			catch (SQLException e)
			{}
		}
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e)
			{ }
		}
	}
}
