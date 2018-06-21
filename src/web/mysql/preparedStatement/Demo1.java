package web.mysql.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

/*
 * 模拟用户输入
 */

public class Demo1 {
	private String url = "jdbc:mysql://localhost:3306/day16";
	private String usr = "root";
	private String pwd = "123456";
	
	@Test
	public void testByStatement() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection(url, usr, pwd);
			//创建Statement
			stmt = conn.createStatement();
			//输入待查询数据
			Scanner in = new Scanner(System.in);
			String name = in.nextLine();
			String gender = in.nextLine(); //gender' OR '1=1 sql注入
			String sql = "SELECT * FROM boss WHERE NAME='"+name+"' AND gender='"+gender+"'";
			//执行sql语句
			rs = stmt.executeQuery(sql);
			//遍历结果
			while (rs.next()) {
				int id = rs.getInt("id");
				name = rs.getString("name");
				gender = rs.getString("gender");
				System.out.println(id+"\t"+name+"\t"+gender);
			}
			//关闭输入流
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
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
