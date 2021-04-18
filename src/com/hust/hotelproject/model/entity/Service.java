package com.hust.hotelproject.model.entity;

public class Service {
	String serviceId;
	String name;
	long price;
	public Service(String serviceId, String name, long price) {
		super();
		this.serviceId = serviceId;
		this.name = name;
		this.price = price;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", name=" + name + ", price=" + price + "]";
	}
	
}
