package com.hust.hotelproject.controller;
import java.util.List;

import com.hust.hotelproject.model.dao.EmployeeDao;
import com.hust.hotelproject.model.entity.*;
import com.hust.hotelproject.util.Logger;
public class EmployeeController {
	private EmployeeDao employeeDao;
	
	public EmployeeController() {
		this.employeeDao = new EmployeeDao();
	}
	
	public List<Employee> returnAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
	public boolean insertEmployee(Employee employee) {
		boolean check = employeeDao.insertEmployee(employee);
		if(check) {
			Logger.info("Insert success");
		} else {
			Logger.error("Insert false");
		}
		return check;
	}
	
	public void deleteEmployee(String employeeId) {
		employeeDao.deleteEmployee(employeeId);
		Logger.info("Delete success");
	}
	
	public List<Employee> findEmployee(String name) {
		return employeeDao.findEmployee(name);
	}
}
