package web.mysql.CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

/*
 * CallableStatement
 */
public class Demo {
	
	private String url = "jdbc:mysql://localhost:3306/day16";
	private String usr = "root";
	private String pwd = "123456";
	
	@Test
	public void test1() {
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection(url, usr, pwd);
			//准备sql语句
			String sql = "CALL pro_findById(?)";
			//预编译
			stmt = conn.prepareCall(sql);
			//设置输入参数
			stmt.setInt(1, 3);
			//发送参数
			rs = stmt.executeQuery(); //所有调用存储过程的sql语句都是executeQuery
			//遍历结果
			while (rs.next()) {
				int id = rs.getInt("id");
				String empName = rs.getString("empName");
				String deptID = rs.getString("deptID");
				System.out.println(id+"\t"+empName+"\t"+deptID);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e + "连接失败");
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e + "连接失败");
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e + "连接失败");
				}
			}
		}
	}
	/*
	 * 执行带有输出参数存储过程
	 */
	@Test
	public void test2() {
		Connection conn = null;
		CallableStatement stmt = null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection(url, usr, pwd);
			//准备sql
			String sql = "CALL pro_testOut(?)"; //注意带CALL
			//预编译
			stmt = conn.prepareCall(sql);
			//注册输出参数
			stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			//发送参数，执行
			stmt.executeQuery(); //结果不返回到结果集，返回到输出参数中
			String ans = stmt.getString(1);
			System.out.println(ans);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e + "连接失败");
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e + "连接失败");
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e + "连接失败");
				}
			}
		}
	}
}
