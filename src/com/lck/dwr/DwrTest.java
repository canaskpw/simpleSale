package com.lck.dwr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lck.bean.Customer;
import com.lck.bean.Inventory;
import com.lck.bean.Product;
import com.lck.bean.Type;
import com.lck.dao.CustomerDao;
import com.lck.dao.InventoryDao;
import com.lck.dao.TypeDao;

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

	// 获取产品类型
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

	// 根据商品类型获取对应库存中所有商品
	public List<Inventory> getInventoryByType(Integer tId) {
		// 调用dao层方法
		InventoryDao dao = new InventoryDao();
		//创建库存集合对象
		List<Inventory> list = new ArrayList<Inventory>();
		// 如果tId为0则表示选择的是所有商品
		if (tId == 0) {
			 list = dao.findAllInventory();
		} else {
			list = dao.findInventoryByType(tId);
		}
		return list;
	}
	
	//根据商品关键字查询商品
	public List<Inventory> getInventoryByWords(String words){
		//调用dao层方法
		InventoryDao dao = new InventoryDao();
		//返回查询到的库存商品结合
		return dao.findInventoryByWords(words);
	}
}
