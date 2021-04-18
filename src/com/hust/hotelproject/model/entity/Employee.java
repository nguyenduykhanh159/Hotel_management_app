package com.hust.hotelproject.model.entity;

public class Employee {
	String employeeId;
	String name;
	String sex;
	String role;
	
	
	public Employee(String employeeId, String name, String sex, String role) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.sex = sex;
		this.role = role;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Employee [employee_id=" + employeeId + ", name=" + name + ", sex=" + sex + ", role=" + role + "]";
	}
	
	
}

