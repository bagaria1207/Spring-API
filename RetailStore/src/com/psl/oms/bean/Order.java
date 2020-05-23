package com.psl.oms.bean;

public class Order {
	
	private int ordId;
	private int custId;
	private String prodName;
	private int prodQuant;

	public Order() {
		
	}

	public Order(int ordId, int custId, String prodName, int prodQuant) {
		super();
		this.ordId = ordId;
		this.custId = custId;
		this.prodName = prodName;
		this.prodQuant = prodQuant;
	}

	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdQuant() {
		return prodQuant;
	}

	public void setProdQuant(int prodQuant) {
		this.prodQuant = prodQuant;
	}

	@Override
	public String toString() {
		return "Order [ordId=" + ordId + ", custId=" + custId + ", prodName=" + prodName + ", prodQuant=" + prodQuant
				+ "]";
	}
	
}