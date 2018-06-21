package web.mysql.dml;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import web.mysql.util.JDBCUtils;

public class Demo2 {
	private String url = "jdbc:mysql://localhost:3306/day16";
	private String usr = "root";
	private String pwd = "123456";
	
	/*
	 * 增加数据
	 */
	@Test
	public void test() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}

}
