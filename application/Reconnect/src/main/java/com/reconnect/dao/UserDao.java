package com.reconnect.dao;


import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reconnect.dao.util.CityDaoInterface;
import com.reconnect.dao.util.ContactDaoInterface;
import com.reconnect.dao.util.LoginDaoInterface;
import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.factory.CityDAOFactory;
import com.reconnect.factory.LoginDAOFactory;
import com.reconnect.model.City;
import com.reconnect.model.User;
import com.reconnect.model.UserLogin;
import com.reconnect.utility.DBUtils;

public class UserDao implements UserDaoInterface {

	Connection conn = null;
	CityDaoInterface cityDao = null;
	LoginDaoInterface loginDao = null;
	ContactDaoInterface contactDao = null;

	public UserDao() {
		conn = DBUtils.getConnection();
		cityDao = CityDAOFactory.createCityDaoObject(); //Gets the instance of cityDao interface
		loginDao = LoginDAOFactory.createLoginDaoObject(); //Gets the instance of loginDao interface
		//contactDao = ContactDAOFactory.createObject(); //Gets instance of contactDao interface
	}

	//Method checks the login credentials of the user
	@Override
	public int loginValidation(UserLogin ul) {
		int loginFlag = loginDao.checkLoginCredentials(ul);
		if (loginFlag == 0 || loginFlag == -1)
			return loginFlag;
		else
			return 1;
	}

	//Checks whether the city exists or not. If not, creates a new city row and returns the city_id
	@Override
	public int registerUserCity(City c) {
		return cityDao.getCityId(c);
	}

	//Checks the login credentials of the user.
	@Override
	public int registerUserCred(UserLogin ul) {
		return loginDao.registerCredentials(ul);
	}

	//Checks whether the email is unique or not in the user_details table
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

	//Returns user_id of the user according to username
	@Override
	public int getUserId(String username) {
		PreparedStatement pstmt = null;
		String sql = "select user_id from user_details ud, credentials c where c.username=? and c.credential_id=ud.credential_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
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


	// Register the user into the system.
	@Override
	public boolean registerUserDetail(User userDetails, int city_id, int cred_id) throws FileNotFoundException {
		PreparedStatement pstmt = null;
		String sql = "insert into user_details(first_name, last_name, email_id, phone_no, gender, dob, address, city_id, profile_image_path, credential_id, company) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {

			System.out.println(userDetails.getProfileImagePath());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDetails.getFname());
			pstmt.setString(2, userDetails.getLname());
			pstmt.setString(3, userDetails.getEmail());
			pstmt.setString(4, userDetails.getPhone());
			pstmt.setString(5, userDetails.getGender());
			pstmt.setDate(6, userDetails.getDob());
			pstmt.setString(7, userDetails.getAddress());
			pstmt.setInt(8, city_id);
			//pstmt.setBlob(9, userDetails.getProfileImage());
			//FileInputStream picture=new FileInputStream(userDetails.getProfileImage().getAbsolutePath());
			pstmt.setString(9,userDetails.getProfileImagePath());
			pstmt.setInt(10, cred_id);
			pstmt.setString(11, userDetails.getCompany());
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


	//Check whether the username is unique or not in the credentials table.
	@Override
	public boolean checkUsernameUniq(String username) {
		PreparedStatement pstmt = null;
		String sql = "select 1 from user_details ud, credentials c where c.username=? and c.credential_id=ud.credential_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
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


	//Returns user details according to username.
	@Override
	public User getUserDetailsByUsername(String username) {
		PreparedStatement pstmt = null;
		User user = null;
		String sql = "select * from user_details ud, credentials c, city_details ct where c.username=? and c.credential_id=ud.credential_id and ct.city_id=ud.city_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_id"),rs.getString("phone_no"), rs.getString("gender"),rs.getDate("dob"),rs.getString("address"), rs.getString("company"), rs.getString("profile_image_path"), new City(rs.getString("city"), rs.getString("state"), rs.getString("country")));
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
		return user;
	}

	//Returns user details according to first name and last name
	@Override
	public List<User> getUserDetailsByName(String firstName, String lastName) {
		PreparedStatement pstmt = null;
		List<User> userList = new ArrayList<>();
		String sql = "select c.username, ud.first_name, ud.last_name, ct.city, ct.state, ct.country from user_details ud, city_details ct, credentials c where c.credential_id=ud.credential_id and ct.city_id=ud.city_id and first_name=? or last_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), new City(rs.getString(4), rs.getString(5), rs.getString(6))));
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
		return userList;
	}

	//Returns user details(Username, first name, last name, city, state, country) according to city
	@Override
	public List<User> getUserDetailsByCity(String city) {
		PreparedStatement pstmt = null;
		List<User> userList = new ArrayList<>();
		String sql = "select c.username,ud.first_name, ud.last_name, ct.city, ct.state, ct.country from user_details ud, city_details ct, credentials c where c.credential_id=ud.credential_id and ct.city=? and ct.city_id=ud.city_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), new City(rs.getString(4), rs.getString(5), rs.getString(6))));
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
		return userList;
	}

	//Returns user details(Username, first name, last name, city, state, country) according to state
	@Override
	public List<User> getUserDetailsByState(String state) {
		PreparedStatement pstmt = null;
		List<User> userList = new ArrayList<>();
		String sql = "select c.username, ud.first_name, ud.last_name, ct.city, ct.state, ct.country from user_details ud, city_details ct, credentials c where c.credential_id=ud.credential_id and ct.state=? and ct.city_id=ud.city_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, state);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), new City(rs.getString(4), rs.getString(5), rs.getString(6))));
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
		return userList;
	}

	//Returns user details(Username, first name, last name, city, state, country) according to country
	@Override
	public List<User> getUserDetailsByCountry(String country) {
		PreparedStatement pstmt = null;
		List<User> userList = new ArrayList<>();
		String sql = "select c.username,ud.first_name, ud.last_name, ct.city, ct.state, ct.country from user_details ud, city_details ct, credentials c where c.credential_id=ud.credential_id and ct.country=? and ct.city_id=ud.city_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, country);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), new City(rs.getString(4), rs.getString(5), rs.getString(6))));
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
		return userList;
	}

	//Returns user details(Username, first name, last name, city, state, country) according to user id
	@Override
	public User getUserDetailsById(int userId) {
		PreparedStatement pstmt = null;
		User user = null;
		String sql = "select c.username,ud.first_name, ud.last_name, ct.city, ct.state, ct.country from user_details ud, city_details ct, credentials c where c.credential_id=ud.credential_id and ud.user_id=? and ct.city_id=ud.city_id";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), new City(rs.getString(4), rs.getString(5), rs.getString(6)));
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
		return user;
	}


	//Returns user details(Username, first name, last name, city, state, country) who aren't friends of the user
	@Override
	public List<User> getNonFriendsList(String username) {
		PreparedStatement pstmt = null;
		int userId = getUserId(username);
		List<User> userList = new ArrayList<>();
		String sql = "select c.username, ud.first_name, ud.last_name, ct.city, ct.state, ct.country from user_details ud, city_details ct, credentials c where c.credential_id=ud.credential_id and ct.city_id=ud.city_id and user_id!=? and user_id not in (select friend_two from friend_details where (friend_one=? or friend_two=?) and status=1)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), new City(rs.getString(4), rs.getString(5), rs.getString(6))));
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
		return userList;
	}

	@Override
	public User getUserDetailsByEmail(String email) {

		User user = null;
		PreparedStatement pstmt = null;
		String sql = "select * from user_details ud, credentials c, city_details ct where ud.email_id=? and c.credential_id=ud.credential_id and ct.city_id=ud.city_id";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_id"),rs.getString("phone_no"), rs.getString("gender"),rs.getDate("dob"),rs.getString("address"), rs.getString("company"), rs.getString("profile_image_path"), new City(rs.getString("city"), rs.getString("state"), rs.getString("country")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return user;

	}
}