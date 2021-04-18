/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.hotelproject.controller;

import com.hust.hotelproject.model.dao.CustomerDao;
import com.hust.hotelproject.model.entity.Customer;
import com.hust.hotelproject.util.Logger;
import java.util.List;

/**
 *
 * @author hoangminh
 */
public class CustomerController {
    CustomerDao customerDao;
    public CustomerController() {
        this.customerDao = new CustomerDao();
    }
    
    public List<Customer> returnAllCustomer() {
        return customerDao.getAllRoom();
    }
    
    public List<Customer> findCustomer(String name) {
        return customerDao.findCustomer(name);
    }
    
    public boolean insertCustomer(Customer customer) {
		boolean check = customerDao.insertCustomer(customer);
		if(check) {
			Logger.info("Insert success");
		} else {
			Logger.error("Insert false");
		}
		return check;
	} 
    
    public void deleteCustomer(String customerId) {
        customerDao.deleteCustomer(customerId);
    }
}
