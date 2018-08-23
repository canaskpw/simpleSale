package com.lck.bean;

public class OrderItem {
	//订单项编号
	private Integer oId;
	
	//维护库存商品对象
	private Inventory inventory;
	
	//订单数量
	private Integer num;

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public OrderItem(Integer oId, Inventory inventory, Integer num) {
		super();
		this.oId = oId;
		this.inventory = inventory;
		this.num = num;
	}

	public OrderItem() {
		super();
	}
	
	
}
