package com.hust.hotelproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.model.entity.Service;

public class ServiceDao {
	public List<Service> getAllService() {
		List<Service> listService = new ArrayList<>();
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from service";
			statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					Service service = new Service(result.getString(1), result.getString(2), result.getLong(3));
					listService.add(service);
				}
			} finally {
				try {
					result.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listService;
	}
	
	public List<Service> findService(String name) {
		List<Service> listService = new ArrayList<>();
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from service where name LIKE '%"+ name +"%'";
			statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					Service service = new Service(result.getString(1), result.getString(2),result.getLong(3));
					listService.add(service);
				}
			} finally {
				try {
					result.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listService;
	}
	
	public boolean insertService(Service service) {
		PreparedStatement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			final String sql = "INSERT INTO service VALUES (?, ?, ?)";
			statement = con.prepareCall(sql);
			statement.setString(1, service.getServiceId());
			statement.setString(2, service.getName());
			statement.setLong(3, service.getPrice());
			
			
			// TODO: String.format
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public void deleteService(String serviceId) {
		PreparedStatement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			final String sql = "DELETE FROM service WHERE service_id = ?";
			statement = con.prepareCall(sql);
			statement.setString(1, serviceId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
