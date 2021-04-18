package com.hust.hotelproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.model.entity.Customer;
import com.hust.hotelproject.util.CloseDB;

public class CustomerDao {
	public List<Customer> getAllRoom() {
		List<Customer> listCustomer = new ArrayList<>();
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from customer";
			statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					Customer customer = new Customer(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
					listCustomer.add(customer);
				}
			} finally {
				CloseDB.closeResultSet(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB.closeStatement(statement);
		}
		return listCustomer;
	}
	
	public List<Customer> findCustomer(String name) {
		List<Customer> listCustomer = new ArrayList<>();
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from customer where name = '"+ name +"'";
			statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					Customer customer = new Customer(result.getString(1), result.getString(2),result.getString(3), result.getString(4), result.getString(5));
					listCustomer.add(customer);
				}
			} finally {
				CloseDB.closeResultSet(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB.closeStatement(statement);
		}
		return listCustomer;
	}

	
	public boolean insertCustomer(Customer customer) {
		PreparedStatement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			final String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?)";
			statement = con.prepareCall(sql);
			statement.setString(1, customer.getCustomerId());
			statement.setString(2, customer.getName());
			statement.setString(3, customer.getAddress());
			statement.setString(4, customer.getIndentityNumber());
			statement.setString(5, customer.getPhone());
			
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			CloseDB.closeStatement(statement);
		}
		return true;
	}
	
	public void deleteCustomer(String customerId) {
		PreparedStatement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			final String sql = "DELETE FROM customer WHERE customer_id = ?";
			statement = con.prepareCall(sql);
			statement.setString(1, customerId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDB.closeStatement(statement);
		}
	}
}
