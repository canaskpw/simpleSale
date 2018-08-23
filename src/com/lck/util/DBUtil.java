package com.lck.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public final class DBUtil {
	// 维护数据源
	private static BasicDataSource ds = null;

	// 静态代码块，只执行一次
	static {

		try {
			// 创建数据源
			ds = new BasicDataSource();
			// 配置文件对象
			Properties pro = new Properties();
			// 加载配置文件
			pro.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			// 设置数据源属性
			ds.setMaxActive(Integer.parseInt(pro.getProperty("maxActive")));// 最大连接数
			ds.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));// 最大空闲连接数
			ds.setMaxWait(Long.parseLong(pro.getProperty("maxWait")));// 最大等待超时时间
			ds.setDriverClassName(pro.getProperty("driverClassName"));// 加载驱动
			ds.setUrl(pro.getProperty("url"));// 连接地址
			ds.setUsername(pro.getProperty("username"));// 用户名
			ds.setPassword(pro.getProperty("password"));// 密码
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 获取连接的方法
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn= ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭连接的方法
	public static void close(ResultSet rs,Statement stm,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stm!=null){
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
