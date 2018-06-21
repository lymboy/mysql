package web.mysql.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.Test;

public class Demo {
	private String url = "jdbc:mysql://localhost:3306/day16";
	private String usr = "root";
	private String pwd = "123456";
	
	/*
	 * 增加
	 */
	@Test
	public void testInsert() {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection(url, usr, pwd);
			//准备预编译的sql
			String sql = "INSERT INTO boss(id, NAME, gender) VALUES(?, ?, ?)";
			//执行预编译的sql语句
			stmt = conn.prepareStatement(sql);
			//设置参数
			stmt.setInt(1, 1);
			stmt.setString(2, "John");
			stmt.setString(3, "man");
			int count = stmt.executeUpdate();
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		}
	}
}
