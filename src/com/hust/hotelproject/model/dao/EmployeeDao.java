package com.hust.hotelproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.model.entity.Employee;

public class EmployeeDao {
	private static final String TABLE = "employee";

	public List<Employee> getAllEmployee() {
		List<Employee> listemployee = new ArrayList<>();
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from " + TABLE;
			statement = con.createStatement();

			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					Employee employee = new Employee(result.getString("employee_id"), result.getString("name"),
							result.getString("sex"), result.getString("role"));
					listemployee.add(employee);
				}
			} finally {
				closeResultSet(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
		}
		
		return listemployee;
	}

	private void closeStatement(Statement statement) {
		try {
			if (statement != null)
				statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeResultSet(ResultSet result) {
		try {
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Employee> findEmployee(String name) {
		List<Employee> listemployee = new ArrayList<>();
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from " + TABLE + " where name LIKE '%" + name + "%'";
			statement = con.createStatement();

			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					Employee employee = new Employee(result.getString("employee_id"), result.getString("name"),
							result.getString("sex"), result.getString("role"));
					listemployee.add(employee);
				}
			} finally {
				closeResultSet(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
		}
		return listemployee;
	}

	public boolean insertEmployee(Employee employee) {
		PreparedStatement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			final String sql = "INSERT INTO " + TABLE + " VALUES (?, ?, ?, ?)";
			statement = con.prepareCall(sql);
			statement.setString(1, employee.getEmployeeId());
			statement.setString(2, employee.getName());
			statement.setString(3, employee.getSex());
			statement.setString(4, employee.getRole());

			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeStatement(statement);
		}
		return true;
	}

	public void deleteEmployee(String employeeId) {
		PreparedStatement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			final String sql = "DELETE FROM " + TABLE + " WHERE employee_id = ?";
			statement = con.prepareCall(sql);
			statement.setString(1, employeeId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
		}
	}
}
