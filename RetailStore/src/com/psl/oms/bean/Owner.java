package com.psl.oms.bean;

public class Owner {
	
	private int ownerId;
	private String ownerName;
	private String ownerPass;
	
	public Owner() {
		
	}

	public Owner(int ownerId, String ownerName, String ownerPass) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerPass = ownerPass;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPass() {
		return ownerPass;
	}

	public void setOwnerPass(String ownerPass) {
		this.ownerPass = ownerPass;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerPass=" + ownerPass + "]";
	}

}
