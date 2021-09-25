package com.reconnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reconnect.dao.util.LoginDaoInterface;
import com.reconnect.model.UserLogin;
import com.reconnect.utility.DBUtils;

public class LoginDao implements LoginDaoInterface{
	
	Connection conn = null;
	
	//Intializes the connection class
	public LoginDao() {
		conn = DBUtils.getConnection();
	}
	
	//Checks the login credential of he user
	public int checkLoginCredentials(UserLogin userLogin){
		PreparedStatement pstmt = null;
		String sql = "select * from credentials where username=? and user_password=?";
		try {
			System.out.println("In Login dao");
			pstmt = conn.prepareStatement(sql);
			//System.out.println(userLogin.getUserName());
			pstmt.setString(1, userLogin.getUserName());
			pstmt.setString(2, userLogin.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getBoolean(5) && updateLastLogin(userLogin)) {
					//System.out.println(rs.getInt(1));
					return rs.getInt(1); // Returns the username of logged in user.
				}else {
					return 0; //Deactivated User
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1; //Wrong credentials
	}
	
	//Register the user (Insert the credential details[username, password]  in credential table)
	public int registerCredentials(UserLogin ul) {
		PreparedStatement pstmt = null;
		String sql = "insert into credentials(username, user_password) values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ul.getUserName());
			pstmt.setString(2, ul.getPassword());
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return checkLoginCredentials(ul);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	//Updates the last login of the user according to username
	public boolean updateLastLogin(UserLogin ul) {
		PreparedStatement pstmt = null;
		String sql = "update credentials set last_login =? where username=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime())); //Get timestamp when user logged in into the system
			pstmt.setString(2, ul.getUserName());
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
