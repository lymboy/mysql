package web.mysql.dml;

import java.sql.Connection;
import java.sql.DriverManager;
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
	public void testInsert() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//通过工具类获取对象
			conn = JDBCUtils.getConnection();
			//创建Statement语句
			stmt = conn.createStatement();
			//sql语句
			String sql = "INSERT INTO boss(id, NAME, gender) VALUES(1, 'John', 'man'), (2, 'Kevin', 'woman')";
			//执行sql语句
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}
	
	/*
	 * 更改数据
	 */
	@Test
	public void testUpdate() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//工具类获取连接
			conn = JDBCUtils.getConnection();
			//创建Statement对象
			stmt = conn.createStatement();
			//sql语句
			String sql = "UPDATE boss SET NAME='Lily' WHERE id=2";
			//执行sql
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		} finally {
			//关闭资源
			JDBCUtils.close(conn, stmt);
		}
	}
	
	/*
	 * 删除数据
	 */
	@Test
	public void testDelete() {
		Connection conn = null;
		Statement stmt= null;
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//驱动管理器获取连接
			conn = DriverManager.getConnection(url, usr, pwd);
			//创建Statement对象
			stmt = conn.createStatement();
			//sql语句
			String sql = "DELETE FROM boss WHERE id=1";
			//执行sql
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		}
	}

}
