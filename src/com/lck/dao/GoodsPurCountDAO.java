package com.lck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lck.bean.GoodsPurCount;
import com.lck.util.DBUtil2;

public class GoodsPurCountDAO {
	/**
	 * 商品采购统计报表  商品采购明细,查询所有数据方法
	 * @return
	 */
	public List<GoodsPurCount> getList(){
		
		List<GoodsPurCount> GoodsPurCountlist = new ArrayList<GoodsPurCount>();
		String sql = "select * from t_purchasegood2 pur "+
						  "join t_product2 p on p.p_id = pur.p_id "+
						  "join t_empl2 e on e.e_id = pur.e_id "+
						  "join t_supplier2 sup on sup.s_id = pur.s_id";
		try {
			Connection con = DBUtil2.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				GoodsPurCount gpclCount = new GoodsPurCount();
				gpclCount.setPurId(rs.getInt("pur_id"));
				gpclCount.setPurTime(rs.getString("pur_time"));
				gpclCount.setsName(rs.getString("s_name"));
				gpclCount.setpId(rs.getInt("p_id"));
				gpclCount.setpName(rs.getString("p_name"));
				gpclCount.setpUnit(rs.getString("p_unit"));
				gpclCount.setPurPrice(rs.getDouble("pur_price"));
				gpclCount.setPurNum(rs.getInt("pur_num"));
				//gpclCount.setPurPriceNum(rs.getDouble(""));
				gpclCount.seteName(rs.getString("e_name"));
				
				GoodsPurCountlist.add(gpclCount);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GoodsPurCountlist;
	}
}
