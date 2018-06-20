package web.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import web.mysql.util.JDBCUtils;

public class Demo3 {
	
	@Test
	public void test() {
			Statement stmt = null;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}
	
}
