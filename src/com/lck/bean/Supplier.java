package com.lck.bean;

//--供货商
public class Supplier {
	//供应商ID
	private Integer sId;
	//供应商名称
	private String  sName;
	
	public Supplier() {
		super();
	}

	public Supplier(Integer sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}
	
	
}
