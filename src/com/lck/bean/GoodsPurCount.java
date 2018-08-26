package com.lck.bean;

public class GoodsPurCount {
	//进货编号，商品编号联合主键
	private Integer purId;
	//时间
	private String  purTime;
	//供应商名称
	private String  sName;
	//商品编号
	private Integer pId;
	//商品名称
	private String pName;
	//商品单位
	private String pUnit;
	//进货价格
	private double purPrice;
	//进货数量
	private Integer	purNum;
	//总余额：进货表_进货价格 *进货表_进货数量 pur_price* pur_num
	private double purPriceNum;	
	//员工用户名
	private String eName;
	
	public GoodsPurCount() {
		
	}

	public GoodsPurCount(Integer purId, String purTime, String sName, Integer pId, String pName, String pUnit,
			double purPrice, Integer purNum, double purPriceNum, String eName) {
		
		this.purId = purId;
		this.purTime = purTime;
		this.sName = sName;
		this.pId = pId;
		this.pName = pName;
		this.pUnit = pUnit;
		this.purPrice = purPrice;
		this.purNum = purNum;
		this.purPriceNum = purPriceNum;
		this.eName = eName;
	}

	public Integer getPurId() {
		return purId;
	}

	public void setPurId(Integer purId) {
		this.purId = purId;
	}

	public String getPurTime() {
		return purTime;
	}

	public void setPurTime(String purTime) {
		this.purTime = purTime;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
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

	public double getPurPrice() {
		return purPrice;
	}

	public void setPurPrice(double purPrice) {
		this.purPrice = purPrice;
	}

	public Integer getPurNum() {
		return purNum;
	}

	public void setPurNum(Integer purNum) {
		this.purNum = purNum;
	}

	public double getPurPriceNum() {
		return purPriceNum;
	}

	public void setPurPriceNum(double purPriceNum) {
		this.purPriceNum = purPriceNum;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}
	
	
}
