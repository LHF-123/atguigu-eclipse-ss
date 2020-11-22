package com.lhf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDao {
	/* 1、加载驱动，Class.forName();
	 * 2、获得连接对象
	 * 3、发送sql语句 -->对于查询，要进行结果集的处理
	 * 4、关闭连接
	 * */
	
	private static final String URL="jdbc:mysql://localhost:3306/jdbc";
	private static final String USERNAME = "root";
	private static final String PWD = "123456";
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static void updata() {//对数据库进行增删改
		try {
			Class.forName("com.mysql.jdbc.Driver");//1、加载驱动，可能会抛出ClassNotFoundExceptio
			conn = DriverManager.getConnection(URL,USERNAME,PWD);//获取连接对象，可能会抛出SQLException
			stmt = conn.createStatement();
//			String sql = "INSERT INTO user(uname,pwd) VALUES('jerry','123')";增
			//对于自增长字段，插入时：1、指定列，将改跳过  2、可以使用NULL值
//			String sql = "DELETE FROM user WHERE id = 1";删
			String sql = "UPDATE user SET uname = 'marry' WHERE id = 2";//改
			int count = stmt.executeUpdate(sql);
			if(count == 1)
				System.out.println("插入数据成功");
			else {
				System.out.println("插入数据失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {//肯定会执行的代码
			try {//4、关闭
				if(stmt != null)
				stmt.close();//后出现的先关闭
				if(conn != null)
					conn.close();//先出现的后关闭
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void query() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USERNAME,PWD);//获取连接对象，可能会抛出SQLException
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("uname");
				String pwd = rs.getString(3);//平时用的数组下标是从0开始，此时的列是从1开始
				System.out.println("id:" + id + "姓名:" + name + "密码:" + pwd);
			}
			}
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null)
						rs.close();
					if(stmt != null)
					stmt.close();//后出现的先关闭
					if(conn != null)
						conn.close();//先出现的后关闭
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
		
	public static void main(String[] args) {
//		updata();
		query();
	}

}
