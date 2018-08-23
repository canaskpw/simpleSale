package com.lck.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lck.base.BaseJdbcDao;
import com.lck.base.RowMapper;
import com.lck.bean.Inventory;

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
	
	//根据商品编号查出对应库存表中的商品数据,以及商品类型（3表连表查询）
	public Inventory findInventoryByPid(Integer pId){
		return this.queryForObject(
				"select * from t_inventory i ,t_product2 p,t_type2 t  where i.p_id = p.p_id and t.t_id = p.t_id and i.p_id =?",
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
						inventory.setType(rs.getString("t_name"));
						return inventory;
					}
				}, 
				pId
				);
	}
	
	//根据商品类型查询对应的商品
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
				tId
		);
	}
	
	//根据关键字查询商品
	public List<Inventory> findInventoryByWords(String words){
		return this.queryForList(
				"select * from t_inventory i,t_product2 p where p.p_id = i.p_id and p.p_name like ?", 
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
				"%"+words+"%"
		);
	}
}
