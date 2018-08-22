package com.sale.bean;

public class Product {
	//商品编号
	private Integer pId;
	//商品名称
	private String pName;
	//商品售价
	private double pSalePrice;
	//商品单位
	private String pUnit;
	//商品类型（外键）
	private Integer tId;
	//商品类型
	private String pType;
	
	
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getpSalePrice() {
		return pSalePrice;
	}
	public void setpSalePrice(double pSalePrice) {
		this.pSalePrice = pSalePrice;
	}
	public String getpUnit() {
		return pUnit;
	}
	public void setpUnit(String pUnit) {
		this.pUnit = pUnit;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	
	public Product(Integer pId, String pName, double pSalePrice, String pUnit, Integer tId,String pType) {
		this.pId = pId;
		this.pName = pName;
		this.pSalePrice = pSalePrice;
		this.pUnit = pUnit;
		this.tId = tId;
		this.pType = pType;
	}
	
	public Product() {
		
	}
	
	
}
