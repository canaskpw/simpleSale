package com.sale.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sale.base.BaseJdbcDao;
import com.sale.base.RowMapper;
import com.sale.bean.Product;

public class ProductDao extends BaseJdbcDao<Product>{
	// 根据产品id查询出产品名字
	public Product getNameByTypeId(int pId) {
		return this.queryForObject("select t_name from t_type2 where t_id = ?;", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs) throws SQLException {
				// 创建Type对象
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
