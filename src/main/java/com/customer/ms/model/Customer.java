package com.customer.ms.model;

public class Customer {
	
	public Customer(String custId, String custName, String address)
	{
		this.custId = custId;
		this.custName = custName;
		this.address = address;
	}

	private String custId;
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String custName;
	private String address;
	
}
