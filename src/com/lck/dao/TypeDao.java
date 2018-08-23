package com.lck.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lck.base.BaseJdbcDao;
import com.lck.base.RowMapper;
import com.lck.bean.Type;

public class TypeDao extends BaseJdbcDao<Type> {
	// 查询出所有类型
	public List<Type> findAllType() {
		return this.queryForList("select * from t_type2", new RowMapper<Type>() {
			@Override
			public Type mapRow(ResultSet rs) throws SQLException {
				// 创建客户对象
				Type type = new Type();
				type.settId(rs.getInt("t_id"));
				type.settName(rs.getString("t_name"));
				return type;
			}
		});
	}

	// 根据类型id查询出类型名字
	public Type getNameByTypeId(int tId) {
		return this.queryForObject("select t_name from t_type2 where t_id = ?;", new RowMapper<Type>() {
			@Override
			public Type mapRow(ResultSet rs) throws SQLException {
				//创建Type对象
				Type type = new Type();
				type.settId(rs.getInt("t_id"));
				type.settName(rs.getString("t_name"));
				return type;
			}
		},tId);
	}
}
