package web.mysql.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import web.mysql.util.JDBCUtils;

public class QueryRunnerDemo {
	private static Connection conn = JDBCUtils.getConnection();
	
	/*
	 * 添加数据
	 */
	@Test
	public void insert() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO student(NAME, gender, address) VALUES(?,?,?)";
		Object[] params = {"Jordan", "男", "LosAgenle"};
		int count = qr.update(conn, sql, params);
		System.out.println(count);
		//以不抛异常方式关闭资源
		DbUtils.closeQuietly(conn);
	}
	
	/*
	 * 更新数据
	 */
	@Test
	public void update() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE student SET address=? WHERE id=4";
		int count = qr.update(conn, sql, "LosAngeles");
		System.out.println(count);
		//以不抛异常方式关闭资源
		DbUtils.closeQuietly(conn);
	}
	
	/*
	 * 删除数据
	 */
	@Test
	public void delete() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM student WHERE id=?";
		int count = qr.update(conn, sql, 1);
		System.out.println(count);
		DbUtils.closeQuietly(conn);
	}
}
