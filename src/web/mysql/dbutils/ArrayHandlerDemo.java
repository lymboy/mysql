package web.mysql.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.junit.Test;

import web.mysql.util.JDBCUtils;

public class ArrayHandlerDemo {
	private static Connection conn = JDBCUtils.getConnection();
	
	@Test
	public void test1() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM student";
		Object[] result = qr.query(conn, sql, new ArrayHandler());
		for (var obj : result) {
			System.out.println(obj);
		}
		DbUtils.closeQuietly(conn);
	}
	
	@Test
	public void test2() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM student";
		List<Object[]> result = qr.query(conn, sql, new ArrayListHandler());
		for (var res : result) {
			System.out.println(Arrays.toString(res));
		}
		DbUtils.closeQuietly(conn);
	}
}
