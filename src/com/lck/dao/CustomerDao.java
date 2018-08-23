package com.lck.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lck.base.BaseJdbcDao;
import com.lck.base.RowMapper;
import com.lck.bean.Customer;

public class CustomerDao extends BaseJdbcDao<Customer> {
	//查询出所有的员工
	public List<Customer> findAllCustomer(){
		return this.queryForList("select * from t_customer2", 
			new RowMapper<Customer>() {
				@Override
				public Customer mapRow(ResultSet rs) throws SQLException {
					//创建客户对象
					Customer customer = new Customer();
					customer.setCusId(rs.getInt("cus_id"));
					customer.setCusName(rs.getString("cus_name"));
					customer.setCusTel(rs.getString("cus_tel"));
					customer.setCusContacts(rs.getString("cus_contacts"));
					customer.setCusArea(rs.getString("cus_area"));
					customer.setCusType(rs.getInt("cus_type"));
					return customer;
			}
		});
	}
	
}
