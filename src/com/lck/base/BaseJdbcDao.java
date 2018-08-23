package com.lck.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lck.bean.Customer;
import com.lck.util.DBUtil;

public class BaseJdbcDao<T> {
	
	// ͨ�õ���ɾ�ķ���
	public int update(String sql, Object... args) {
		// �������Ӷ���
		Connection conn = null;
		PreparedStatement pstm = null;
		// ��Ӱ�������
		int count = 0;
		// Ԥ����sql
		try {
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			// �������ҪԤ�����
			if (0 != args.length) {
				// ������������̬��ֵ
				for (int i = 0; i < args.length; i++) {
					pstm.setObject(i+1, args[i]);
				}
			}
			//ִ��sql
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر�����
			DBUtil.close(null, pstm, conn);
		}

		return count;
	}
	
	
	//��ѯ���ص�������
	public T queryForObject(String sql,RowMapper<T> rowMapper,Object...args){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		T t = null;
		try {
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			//��̬��ֵ
			if(0!=args.length){
				for(int i =0;i<args.length;i++){
					pstm.setObject(i+1,  args[i]);
				}
			}
			//ִ��sql
			rs = pstm.executeQuery();
			//���������
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
	
	//��ѯ���ؼ���
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
			//���������
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