package com.miao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	//centos7系统上的数据库
//	private static final String DBURL = "jdbc:mysql://192.168.31.133:3306/db_affairmanage";
	//ubuntu16.04系统上的数据库
	private static final String DBURL = "jdbc:mysql://192.168.31.134:3306/db_affairmanage";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "111111";
//	private static final String DBPASSWORD = "12345";
	
	/**
	 * 获取数据库的连接
	 * @return	数据库连接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn	数据库连接的对象
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭预处理对象
	 * @param pstmt	预处理对象
	 */
	public static void close(PreparedStatement pstmt){
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭结果集对象
	 * @param rs	结果集对象
	 */
	public static void close(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
