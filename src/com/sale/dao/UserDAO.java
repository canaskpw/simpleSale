package com.sale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sale.util.DBUtil2;

public class UserDAO {

	public boolean checkUser(String usercode,String password){
		String sql = "select * from TUSER where usercode=? and password=?";
		boolean flag = false;
		try {
			Connection con = DBUtil2.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usercode);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				flag = true;
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
