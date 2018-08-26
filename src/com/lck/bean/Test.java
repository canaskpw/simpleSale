package com.lck.bean;

public class Test {

	
	
		//进货编号，商品编号联合主键
		private Integer purId;
		//商品编号（外键）
		private Integer pId;
		//进货价格
		private double purPrice;
		//进货数量
		private Integer	purNum;
		//供货商（外键）
		private Integer sId;
		//状态
		private Integer purStatus;
		//时间
		private String  purTime;
		//员工编号（外键）
		private Integer  eId;
		
		private Product product;

		public Integer getPurId() {
			return purId;
		}

		public void setPurId(Integer purId) {
			this.purId = purId;
		}

		public Integer getpId() {
			return pId;
		}

		public void setpId(Integer pId) {
			this.pId = pId;
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

		public Integer getsId() {
			return sId;
		}

		public void setsId(Integer sId) {
			this.sId = sId;
		}

		public Integer getPurStatus() {
			return purStatus;
		}

		public void setPurStatus(Integer purStatus) {
			this.purStatus = purStatus;
		}

		public String getPurTime() {
			return purTime;
		}

		public void setPurTime(String purTime) {
			this.purTime = purTime;
		}

		public Integer geteId() {
			return eId;
		}

		public void seteId(Integer eId) {
			this.eId = eId;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}
		
		
}
