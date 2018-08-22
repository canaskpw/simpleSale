package com.sale.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sale.bean.Customer;
import com.sale.util.DBUtil;

public class BaseJdbcDao<T> {
	
	// 通用的增删改方法
	public int update(String sql, Object... args) {
		// 建立连接对象
		Connection conn = null;
		PreparedStatement pstm = null;
		// 受影响的行数
		int count = 0;
		// 预编译sql
		try {
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			// 如果有需要预编译的
			if (0 != args.length) {
				// 遍历参数，动态赋值
				for (int i = 0; i < args.length; i++) {
					pstm.setObject(i+1, args[i]);
				}
			}
			//执行sql
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭连接
			DBUtil.close(null, pstm, conn);
		}

		return count;
	}
	
	
	//查询返回单个对象
	public T queryForObject(String sql,RowMapper<T> rowMapper,Object...args){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		T t = null;
		try {
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			//动态赋值
			if(0!=args.length){
				for(int i =0;i<args.length;i++){
					pstm.setObject(i+1,  args[i]);
				}
			}
			//执行sql
			rs = pstm.executeQuery();
			//操作结果集
			while(rs.next()){
				t = rowMapper.mapRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return t;
	}
	
	//查询返回集合
	public List<T> queryForList(String sql,RowMapper<T> rowMapper,Object...args){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		T t = null;
		List<T> list = new ArrayList<T>();
		
		try {
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			if(0!=args.length){
				for(int i=0;i<args.length;i++){
					pstm.setObject(i+1, args[i]);
				}
			}
			rs = pstm.executeQuery();
			//遍历结果集
			while(rs.next()){
				t = rowMapper.mapRow(rs);
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return list;
	}

}
