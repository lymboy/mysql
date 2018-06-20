package web.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo1 
{
	private static String url = "jdbc:mysql://localhost:3306/day16";
	private static String usr = "root";
	private static String pwd = "123456";
	
	@Test
	public void test1()
	{
		Statement stmt = null;
		Connection conn = null;
		
		//注册驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usr, pwd);
			stmt = conn.createStatement();
			String sql = "CREATE TABLE boss(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), gender VARCHAR(2))";
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
;		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
	}
}
