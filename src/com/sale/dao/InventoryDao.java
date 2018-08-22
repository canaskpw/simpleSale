package com.sale.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sale.base.BaseJdbcDao;
import com.sale.base.RowMapper;
import com.sale.bean.Inventory;

public class InventoryDao extends BaseJdbcDao<Inventory>{
	//查询库存所有数据(使用连表查询直接查询出商品信息)
	public List<Inventory> findAllInventory(){
		return this.queryForList("select * from t_inventory i ,t_product2 p where i.p_id = p.p_id", 
			new RowMapper<Inventory>() {
				@Override
				public Inventory mapRow(ResultSet rs) throws SQLException {
					//创建客户对象
					Inventory inventory = new Inventory();
					inventory.setiId(rs.getInt("i_id"));
					inventory.setiNum(rs.getInt("i_num"));//库存
					inventory.setpId(rs.getInt("p_id"));
					inventory.setpName(rs.getString("p_name"));
					inventory.setpSalePrice(rs.getDouble("p_salePrice"));
					inventory.setpUnit(rs.getString("p_unit"));
					return inventory;
			}
		});
	}
	
	//根据商品类型显示对应的商品
	public List<Inventory> findInventoryByType(Integer tId){
		return this.queryForList(
				"select * from t_inventory i ,t_product2 p where i.p_id = p.p_id and p.t_id = ?", 
				new RowMapper<Inventory>() {
					@Override
					public Inventory mapRow(ResultSet rs) throws SQLException {
						//创建客户对象
						Inventory inventory = new Inventory();
						inventory.setiId(rs.getInt("i_id"));
						inventory.setiNum(rs.getInt("i_num"));//库存
						inventory.setpId(rs.getInt("p_id"));
						inventory.setpName(rs.getString("p_name"));
						inventory.setpSalePrice(rs.getDouble("p_salePrice"));
						inventory.setpUnit(rs.getString("p_unit"));
						return inventory;
					}
				}, 
				tId);
	}
}
