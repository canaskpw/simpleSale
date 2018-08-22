package com.sale.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//使用单例模式 创建数据库 不允许继承使用final 针对数据量小  避免频繁打开关闭数据库
public final class DBUtil2 {

	private static final String CLASSNAME = "oracle.jdbc.driver.OracleDriver"; 
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	private static final String USER = "c##test"; 
	private static final String PASSWORD = "123456"; 
	//不管创建多少 都是同一个连接
	private static Connection con = null;
	
	static{
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DBUtil2() {
		
	}
	
	public static Connection getCon(){
		if(con == null){
			try {
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeCon(){
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
