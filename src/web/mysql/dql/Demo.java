package web.mysql.dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

/*
 * 使用Statement语句执行DQL操作
 */

public class Demo {
	private String url = "jdbc:mysql://localhost:3306/day16";
	private String usr = "root";
	private String pwd = "123456";
	
	@Test
	public void test1() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//设置键值对
			Properties props = new Properties();
			props.setProperty("user", usr);
			props.setProperty("password", pwd);
			//获取连接
			conn = DriverManager.getConnection(url, props);
			//创建Statement对象
			stmt = conn.createStatement();
			//执行select 语句
			String sql = "SELECT * FROM student";
			ResultSet res = stmt.executeQuery(sql);
			//遍历结果
			while (res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String gender = res.getString("gender");
				String address = res.getString("address");
				System.out.println(id+"\t"+name+"\t"+gender+"\t"+address);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
