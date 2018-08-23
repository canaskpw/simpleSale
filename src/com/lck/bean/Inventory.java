package com.lck.bean;

public class Inventory {
	// 库存编号
	private Integer iId;

	// 商品编号
	private Integer pId;

	// 商品名称
	private String pName;

	// 商品单位
	private String pUnit;

	// 商品售价
	private Double pSalePrice;

	// 库存量
	private Integer iNum;

	// 商品类型
	private String type;

	public Integer getiId() {
		return iId;
	}

	public void setiId(Integer iId) {
		this.iId = iId;
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

	public String getpUnit() {
		return pUnit;
	}

	public void setpUnit(String pUnit) {
		this.pUnit = pUnit;
	}

	public Double getpSalePrice() {
		return pSalePrice;
	}

	public void setpSalePrice(Double pSalePrice) {
		this.pSalePrice = pSalePrice;
	}

	public Integer getiNum() {
		return iNum;
	}

	public void setiNum(Integer iNum) {
		this.iNum = iNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Inventory() {

	}

	public Inventory(Integer iId, Integer pId, String pName, String pUnit, Double pSalePrice, Integer iNum,
			String type) {
		super();
		this.iId = iId;
		this.pId = pId;
		this.pName = pName;
		this.pUnit = pUnit;
		this.pSalePrice = pSalePrice;
		this.iNum = iNum;
		this.type = type;
	}

}
