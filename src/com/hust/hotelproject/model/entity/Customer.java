package com.hust.hotelproject.model.entity;

public class Customer {
	String customerId;
	String name;
	String address;
	String indentityNumber;
	String phone;
        
        public Customer() {
            
        }
	public Customer(String customerId, String name, String address, String indentityNumber, String phone) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.indentityNumber = indentityNumber;
		this.phone = phone;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIndentityNumber() {
		return indentityNumber;
	}
	public void setIndentityNumber(String indentityNumber) {
		this.indentityNumber = indentityNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address
				+ ", indentityNumber=" + indentityNumber + ", phone=" + phone + "]";
	}
	
}
