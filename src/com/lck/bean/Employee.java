package com.lck.bean;

public class Employee {
	//员工编号
	private Integer eId;
	//员工用户名
	private String eName;
	//员工密码
	private String  ePassword;
	
	public Employee() {
		super();
	}

	public Employee(Integer eId, String eName, String ePassword) {
		
		this.eId = eId;
		this.eName = eName;
		this.ePassword = ePassword;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}
	
	
}
