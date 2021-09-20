package com.reconnect.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	static String url = "jdbc:mysql://localhost:3306/codefury";
	static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "admin@123");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}