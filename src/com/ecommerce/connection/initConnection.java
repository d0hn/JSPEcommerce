package com.ecommerce.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class initConnection {
	String driverClassName = "com.mysql.jdbc.Driver";
	String dbUser = "";
	String dbPwd = "";
	String dBase = "";
	String connectionUrl = "jdbc:mysql:///"+dBase;


	private static initConnection connectionFactory = null;

	private initConnection() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
		return conn;
	}

	public static initConnection getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new initConnection();
		}
		return connectionFactory;
	}
}
