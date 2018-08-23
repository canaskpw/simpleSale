package com.lck.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lck.bean.Inventory;
import com.lck.bean.OrderItem;
import com.lck.dao.InventoryDao;


public class AddOrderItemServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取界面传来的出售数量
		int num = Integer.parseInt(req.getParameter("num"));
		
		//获取库存商品编号
		int pId = Integer.parseInt(req.getParameter("pid"));
		
		//获取界面上的临时订单号
		int orderItemId = Integer.parseInt(req.getParameter("orderId"));
		
		//获得商品对象
		Inventory inventory = new InventoryDao().findInventoryByPid(pId);
		
		//创建一个订单项对象
		OrderItem orderItem = new OrderItem();
		orderItem.setoId(orderItemId);
		orderItem.setInventory(inventory);
		orderItem.setNum(num);
		
		//创建Session对象
		HttpSession session = req.getSession();
		//创建一个临时销售订单的容器
		List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");
		
		//如果为空表示第一加入临时销售订单
		if(orderItems==null){
			//创建临时订单集合
			orderItems = new ArrayList<OrderItem>();
			//设置属性
			session.setAttribute("orderItems", orderItems);
		}
		
		//false表示未找到
		boolean flag = false;
		//遍历临时订单
		for(OrderItem o1 :orderItems){
			//如果临时订单中存在该商品
			if(o1.getInventory().getpId()==inventory.getpId()){
				//临时订单中的数量数量加上该商品的数量
				int oldNum = o1.getNum();
				int newNum = oldNum+num;
				o1.setNum(newNum);
				flag = true;
				break;
			}
		}
		
		//如果临时订单中没有该订单，添加上该订单
		if(!flag){
			orderItems.add(orderItem);
		}

		//重定向到商品销售页面
		resp.sendRedirect("productSale");
	}
}
