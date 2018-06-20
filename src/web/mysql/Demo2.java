package web.mysql;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import web.mysql.util.JDBCUtils;

public class Demo2 {
//	private static String url = "jdbc:mysql://localhost:3306/day16";
//	private static String usr = "root";
//	private static String pwd = "123456";
	
	@Test
	public void testInsert() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO student(name, gender) VALUES('Silly', '女')";
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}
}
