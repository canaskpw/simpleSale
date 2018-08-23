package com.lck.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lck.bean.Inventory;
import com.lck.dao.InventoryDao;
import com.lck.dao.OrderIdDao;

public class ProductSaleServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取库存商品集合
		List<Inventory> inventoryProductList= new InventoryDao().findAllInventory();

		//设置属性（库存列表）
		req.setAttribute("inventoryProductList", inventoryProductList);
		
		//获取当前订单号
		int nextOid = new OrderIdDao().getNextOrderId();
		
		//设置属性（当前订单号）
		req.setAttribute("nextOid", nextOid);
		
		//重定向到商品销售页面
		req.getRequestDispatcher("ProductSale.jsp").forward(req, resp);
	}
}
