package com.psl.oms.bean;

public class Inventory {

	private int prodId;
	private String prodName;
	private int prodQuant;
	private int prodPrice;
	
	public Inventory() {
		
	}

	public Inventory(int prodId, String prodName, int prodQuant, int prodPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodQuant = prodQuant;
		this.prodPrice = prodPrice;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
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

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public String toString() {
		return "Inventory [prodId=" + prodId + ", prodName=" + prodName + ", prodQuant=" + prodQuant + ", prodPrice="
				+ prodPrice + "]";
	}
	
}
