package com.reconnect.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				// Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/codefury";

				con = DriverManager.getConnection(url, "root", "");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
