package com.lck.bean;

public class Type {
	//类型编号
	private Integer tId;
	//类型名称
	private String tName;
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	public Type(Integer tId, String tName) {
		this.tId = tId;
		this.tName = tName;
	}
	
	public Type() {
		
	}
	
	
}
