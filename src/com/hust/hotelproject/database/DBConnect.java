package com.hust.hotelproject.database;

import java.sql.*;

import com.hust.hotelproject.util.Logger;

public class DBConnect {
	
	private DBConnect() {}

	static {
		Logger.info("-------- PostgreSQL JDBC Connection Testing ------------");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			Logger.error("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
		}
	}

	private static Connection instance;

	public static Connection getConnection() {
		if (instance != null) {
			return instance;
		}

		// Create new connection
		try {
			instance = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_final", "postgres", "duykhanhng");
		} catch (SQLException e) {
			Logger.error("Connection Failed! Check output console");
			e.printStackTrace();
		}

		return instance;
	}
}
