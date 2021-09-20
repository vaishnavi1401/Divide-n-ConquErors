package com.reconnect.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.utility.DBUtils;

public class UserDao implements UserDaoInterface {

	Connection conn = null;
	CityDao cityDao = null;
	LoginDao loginDao = null;

	public UserDao() {
		conn = DBUtils.getConnection();
	}

	@Override
	public int loginValidation(UserLogin ul) {
		int loginFlag = loginDao.checkLoginCredentials(ul);
		if (loginFlag == 0 || loginFlag == -1)
			return loginFlag;
		else
			return 1;
	}

	@Override
	public int registerUserCity(City c) {
		return cityDao.getCityId(c);
	}

	@Override
	public int registerUserCred(UserLogin ul) {
		return loginDao.registerCredentials(ul);
	}

	@Override
	public boolean checkEmailUnique(String email) {
		PreparedStatement pstmt = null;
		String sql = "select 1 from user_details where email_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return false;
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
		return true;
	}


	@Override
	public boolean registerUserDetail(User userDetails, int city_id, int cred_id) throws FileNotFoundException {
		PreparedStatement pstmt = null;
		String sql = "insert into user_details(first_name, last_name, email_id, phone_no, gender, dob, address, city_id, profile_image, credential_id) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDetails.getFname());
			pstmt.setString(2, userDetails.getLname());
			pstmt.setString(3, userDetails.getEmail());
			pstmt.setString(4, userDetails.getPhone());
			pstmt.setString(5, userDetails.getGender());
			pstmt.setDate(6, userDetails.getDob());
			pstmt.setString(7, userDetails.getAddress());
			pstmt.setInt(8, city_id);
			FileInputStream picture=new FileInputStream(userDetails.getProfileImage());
			pstmt.setBinaryStream(9,picture,(int)userDetails.getProfileImage().length());
			pstmt.setInt(10, cred_id);
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