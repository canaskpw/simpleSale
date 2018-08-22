package com.sale.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sale.bean.Customer;
import com.sale.bean.Inventory;
import com.sale.bean.Product;
import com.sale.bean.Type;
import com.sale.dao.CustomerDao;
import com.sale.dao.InventoryDao;
import com.sale.dao.TypeDao;

public class DwrTest {

	// 获取客户的方法
	public Map<Integer, String> getCustomer() {
		CustomerDao dao = new CustomerDao();
		List<Customer> list = dao.findAllCustomer();
		// 用map集合接收客户id和客户名字
		Map<Integer, String> map = new HashMap<Integer, String>();
		// 遍历集合向map中添加元素
		for (Customer c : list) {
			map.put(c.getCusId(), c.getCusName());
		}
		return map;
	}
	
	//获取产品类型
	public Map<Integer, String> getType() {
		TypeDao dao = new TypeDao();
		List<Type> list = dao.findAllType();
		// 用map集合接收客户id和客户名字
		Map<Integer, String> map = new HashMap<Integer, String>();
		// 遍历集合向map中添加元素
		for (Type t : list) {
			map.put(t.gettId(), t.gettName());
		}
		return map;
	}	
	
	//根据商品类型获取对应库存中所有商品
	public List<Inventory> getInventoryByType(Integer tId){
		//调用dao层方法
		InventoryDao dao = new InventoryDao();
		List<Inventory> list = dao.findInventoryByType(tId);
		return list;
	}
}
