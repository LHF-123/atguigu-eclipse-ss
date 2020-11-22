package com.llq.student.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	
	//打开数据库连接
	public static Connection getConnection() {
		try {
			Properties properties = new Properties();
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = properties.getProperty("DRIVER");
			url = properties.getProperty("URL");
			user = properties.getProperty("USERNAME");
			pwd = properties.getProperty("UPWD");
			Class.forName(driver);
			return DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//关闭数据库连接
	public static void closeConnection(Connection conn,Statement stmt,ResultSet rs) {
		try {
			if(conn != null) 
				conn.close();
			if(stmt != null) 
				stmt.close();
			if(rs != null) 
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
