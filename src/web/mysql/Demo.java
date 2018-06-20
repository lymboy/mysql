package web.mysql;


import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;
import java.sql.Connection;

public class Demo
{
	private static String url = "jdbc:mysql://localhost:3306/day16";
	private static String usr = "root";
	private static String pwd = "123456";
	
	@Test
	public void test1() throws Exception
	{
		//创建驱动类对象
		Driver driver = new com.mysql.jdbc.Driver();
		//设置密码
		Properties props = new Properties();
		props.setProperty("user", usr);
		props.setProperty("password", pwd);
		//连接数据库
		Connection con = driver.connect(url, props);
		
		System.out.println(con);
	}
	
	@Test
	public void test2() throws Exception
	{
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection(url, usr, pwd);
		System.out.println(con);
	}
	
	@Test
	public void test3 () throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection con = DriverManager.getConnection(url, usr, pwd);
		System.out.println(con);
	}
}
