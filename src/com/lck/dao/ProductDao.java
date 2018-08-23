package com.lck.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lck.base.BaseJdbcDao;
import com.lck.base.RowMapper;
import com.lck.bean.Product;

public class ProductDao extends BaseJdbcDao<Product>{
	// 根据产品id查询出产品
	public Product getProductByPid(int pId) {
		return this.queryForObject("select * from t_product2 where p_id = ?;", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs) throws SQLException {
				// 创建Product对象
				Product product = new Product();
				product.setpId(rs.getInt("p_id"));
				product.setpName(rs.getString("p_name"));
				product.setpSalePrice(rs.getDouble("p_salePrice"));
				product.setpUnit(rs.getString("p_unit"));
				product.settId(rs.getInt("t_id"));
				return product;
			}
		}, pId);
	}
	
	
	//查询所有产品
	public List<Product> findAllCustomer(){
		return this.queryForList("select * from t_product2", 
			new RowMapper<Product>() {
				@Override
				public Product mapRow(ResultSet rs) throws SQLException {
					//创建客户对象
					Product product = new Product();
					product.setpId(rs.getInt("p_id"));
					product.setpName(rs.getString("p_name"));
					product.setpSalePrice(rs.getDouble("p_salePrice"));
					product.setpUnit(rs.getString("p_unit"));
					product.settId(rs.getInt("t_id"));
					return product;
			}
		});
	}
}
