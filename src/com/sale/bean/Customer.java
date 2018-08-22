package com.sale.bean;

public class Customer {
	//客户编号
	private Integer cusId;
	//客户名称
	private String cusName;
	//客户类型（1为普通客户，2为vip客户商品打8折）
	private Integer cusType;
	//联系人
	private String cusContacts;
	//联系电话
	private String cusTel;
	//所属地区
	private String cusArea;
	public Integer getCusId() {
		return cusId;
	}
	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Integer getCusType() {
		return cusType;
	}
	public void setCusType(Integer cusType) {
		this.cusType = cusType;
	}
	public String getCusContacts() {
		return cusContacts;
	}
	public void setCusContacts(String cusContacts) {
		this.cusContacts = cusContacts;
	}
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	public String getCusArea() {
		return cusArea;
	}
	public void setCusArea(String cusArea) {
		this.cusArea = cusArea;
	}
	
	public Customer() {
		
	}
	
	public Customer(Integer cusId, String cusName, Integer cusType, String cusContacts, String cusTel, String cusArea) {
		
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusType = cusType;
		this.cusContacts = cusContacts;
		this.cusTel = cusTel;
		this.cusArea = cusArea;
	}
	
}
