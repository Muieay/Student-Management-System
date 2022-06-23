package com.zyc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Basic {
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306/student?serverTimezone=GMT%2B8&useSSL=false";
	private String username="root";
	private String password="123456";
	public Connection getConn() {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, username, password);
//			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败!");
		}
		return conn;
	}
	
	public void closeAll(ResultSet rs,PreparedStatement pstm,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("资源释放失败");
		}
	}

}
