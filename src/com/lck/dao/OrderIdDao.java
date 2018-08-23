package com.lck.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lck.base.BaseJdbcDao;
import com.lck.base.RowMapper;

public class OrderIdDao extends BaseJdbcDao<Integer> {
	//获取上一条订单号的方法（查询当前序列）
	public Integer getNextOrderId(){
		return this.queryForObject(
				"select seq_order2.nextval from dual", 
				new RowMapper<Integer>() {
					
					@Override
					public Integer mapRow(ResultSet rs) throws SQLException {
						return rs.getInt(1);
					}
				}
				);
	}
}
