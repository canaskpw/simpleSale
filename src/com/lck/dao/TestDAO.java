package com.lck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lck.bean.Test;
import com.lck.util.DBUtil;

public class TestDAO {

	public Test selectAll() {
		
		Test test = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql="select * from t_purchasegood2 pur "+
				"join t_product2 p on p.p_id = pur.p_id "+
				"join t_empl2 e on e.e_id = pur.e_id"+
				"join t_supplier2 sup on sup.s_id = pur.s_id";
		ResultSet rs = null;
		try {
			
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				test.getProduct(rs.getString("p_name"))
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			// �ر�����
			DBUtil.close(null, pstm, conn);
		}

		
	}
	
}
