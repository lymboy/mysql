package web.mysql.dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo {
	private String url = "jdbc:mysql://localhost:3306/day16";
	private String usr = "root";
	private String pwd = "123456";
	@Test
	public void test1() {
		Statement stmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usr, pwd);
			stmt = conn.createStatement();
			String sql = "CREATE TABLE boss(id INT PRIMARY KEY, NAME VARCHAR(20), gender VARCHAR(10))";
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
			
		} catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
