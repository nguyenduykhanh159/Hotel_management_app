package com.hust.hotelproject.model.dto;

import java.util.List;

import com.hust.hotelproject.model.entity.Service;

public class ServiceDto {
	private List<Service> services;

	private String message;

	public ServiceDto(List<Service> services, String message) {
		super();
		this.services = services;
		this.message = message;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
