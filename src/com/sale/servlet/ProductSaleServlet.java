package com.sale.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sale.bean.Inventory;
import com.sale.dao.InventoryDao;

public class ProductSaleServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取库存商品集合
		List<Inventory> inventoryProductList= new InventoryDao().findAllInventory();
		System.out.println(inventoryProductList.toString());
		//设置属性
		req.setAttribute("inventoryProductList", inventoryProductList);
		
		//重定向到商品销售页面
		req.getRequestDispatcher("ProductSale.jsp").forward(req, resp);
	}
}
