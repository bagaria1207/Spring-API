package com.psl.oms.bean;

import java.util.List;

public class Customer {
	
	private int custId;
	private String custName;
	private String custPass;
	private String custAddr;
	private List<Order> order;
	
	public Customer() {
		
	}

	public Customer(int custId, String custName, String custPass, String custAddr, List<Order> order) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custPass = custPass;
		this.custAddr = custAddr;
		this.order = order;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPass() {
		return custPass;
	}

	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custPass=" + custPass + ", custAddr="
				+ custAddr + ", order=" + order + "]";
	}
	
}
