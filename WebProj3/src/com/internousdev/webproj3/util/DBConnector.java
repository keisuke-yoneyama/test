package com.internousdev.webproj3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	/**
	 * JDBCconnectorname
	 *
	 */
	private static String driverName = "com.mysql.jdbc.Driver";
	/**
	 * databaseURL
	 */
	private static String url = "jdbc:mysql://localhost/testdb";
	/**
	 * databaseusername
	 */
	private static String user = "root";
	/**
	 * databasepassword
	 */
	private static String password = "mysql";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
