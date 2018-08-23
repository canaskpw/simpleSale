package com.lck.bean;

//订单表（销售表）
public class Order {

	//订单编号（主键）
	private Integer oId;
	//商品编号（外键）
	private Integer pId;
	//商品数量
	private Integer oNum;
	//小计（商品数量*单价）
	private double oTips;
	//订单时间
	private String oTime;
	//客户编号(外键)
	private Integer cusId;
	//员工编号
	private Integer eId;
	
	public Order() {
		super();
	}

	public Order(Integer oId, Integer pId, Integer oNum, double oTips, String oTime, Integer cusId, Integer eId) {
		super();
		this.oId = oId;
		this.pId = pId;
		this.oNum = oNum;
		this.oTips = oTips;
		this.oTime = oTime;
		this.cusId = cusId;
		this.eId = eId;
	}

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getoNum() {
		return oNum;
	}

	public void setoNum(Integer oNum) {
		this.oNum = oNum;
	}

	public double getoTips() {
		return oTips;
	}

	public void setoTips(double oTips) {
		this.oTips = oTips;
	}

	public String getoTime() {
		return oTime;
	}

	public void setoTime(String oTime) {
		this.oTime = oTime;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}
	
	
}
