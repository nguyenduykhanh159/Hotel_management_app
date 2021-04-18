package com.hust.hotelproject.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.model.entity.*;
import com.hust.hotelproject.util.CloseDB;

public class UserDao {
	
	public List<User> getAllUser() {
		List<User> listUser = new ArrayList<>();
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from useraccount";
			statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					User user = new User(result.getString("username"), result.getString("password"), result.getString("role"));
					listUser.add(user);
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
		
		return listUser;
	}
	
	public User findUser(String username) {
		User user = null;
		Statement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			String sql = "select * from useraccount where username = '" + username +"'";
			statement = con.createStatement();

			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					user = new User(result.getString(1), result.getString(2), result.getString(3), result.getString(4));
				}
			} finally {
				closeResultSet(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
		}
		return user;
	}
        
        public boolean insertUser(User user) {
            PreparedStatement statement = null;
		try {
			Connection con = DBConnect.getConnection();
			final String sql = "INSERT INTO useraccount VALUES (?, ?, ?, ?)";
			statement = con.prepareCall(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRole());
			statement.setString(4, user.getEmployeeId());
			
			
			
			// TODO: String.format
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			CloseDB.closeStatement(statement);
		}
		return true;
        }
        
	private void closeResultSet(ResultSet result) {
		try {
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void closeStatement(Statement statement) {
		try {
			if (statement != null)
				statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	

	