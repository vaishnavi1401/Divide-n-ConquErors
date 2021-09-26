package com.reconnect.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.reconnect.dao.util.CityDaoInterface;
import com.reconnect.dao.util.ContactDaoInterface;
import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.factory.CityDAOFactory;
import com.reconnect.factory.UserDAOFactory;
import com.reconnect.model.City;
import com.reconnect.model.Contact;
import com.reconnect.model.User;
import com.reconnect.utility.DBUtils;

public class ContactDao implements ContactDaoInterface {

	Connection conn = null;
	public CityDaoInterface cd;
	public UserDaoInterface ud;

	public ContactDao()
	{
		conn = DBUtils.getConnection();
		cd =  CityDAOFactory.createCityDaoObject();
		ud = UserDAOFactory.createUserDaoObject();
	}




	//adding contact info by fetching contact obj from servlet for user in session identified by username
	@Override
	public int addContact(Contact c1, String username) throws FileNotFoundException {

		String sql = "insert into contact_details (user_id , first_name , last_name , email_id , phone_no , gender , dob , address , city_id , profile_image_path , creation_date , company) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		PreparedStatement pstmt = null;
		int i1 = 0;

		//fetching userId of current user in session by username
		User u1 = ud.getUserDetailsByUsername(username);
		String em = u1.getEmail();

		try
		{

			Date d1 = c1.getDob();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());	//saving current timestamp in variable

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getUserId(em));
			pstmt.setString(2, c1.getFname());
			pstmt.setString(3, c1.getLname());
			pstmt.setString(4, c1.getEmail());
			pstmt.setString(5 , c1.getPhone());
			pstmt.setString(6 , c1.getGender());
			pstmt.setDate(7, d1);
			pstmt.setString(8, c1.getAddress());
			pstmt.setInt(9, cd.getCityId(c1.getCity1()));
			pstmt.setString(10, c1.getProfileImagePath());
			pstmt.setTimestamp(11, timestamp);
			pstmt.setString(12, c1.getCompany());

			int rs = pstmt.executeUpdate();
			if (rs > 0)
			{
				i1 = 1; //insert executed
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
		return i1;

	}


	//function to fetch userId by email
	@Override
	public int getUserId(String email)
	{
		String sql = "select user_id from user_details where email_id = ?";
		PreparedStatement pstmt = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
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
		return 0;
	}



	//function to return a list of all contacts of particular user, fetching by username
	@Override
	public List<Contact> viewAllContacts(String username) {

		List<Contact> ll = new ArrayList<>();
		String sql = "select * from contact_details where user_id = ?";
		PreparedStatement pstmt = null;

		//fetching userId of current user in session by username
		User u1 = ud.getUserDetailsByUsername(username);
		String em = u1.getEmail();

		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getUserId(em));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				//int uid = rs.getInt(2);
				String fName = rs.getString(3);
				String lName = rs.getString(4);
				String emailId = rs.getString(5);
				String phNo = rs.getString(6);
				String gender = rs.getString(7);
				String company = rs.getString(8);
				Date dob = rs.getDate(9);

				String address = rs.getString(10);
				int cid = rs.getInt(11);
				String profileImagePath = rs.getString(12);
				//Timestamp ts = rs.getTimestamp(13);


				Contact c1 = new Contact();
				City c = fetchCityObj(cid);

				c1.setFname(fName);
				c1.setLname(lName);
				c1.setEmail(emailId);
				c1.setPhone(phNo);
				c1.setGender(gender);
				c1.setDob(dob);
				c1.setAddress(address);
				c1.setCity1(c);
				c1.setProfileImagePath(profileImagePath);
				c1.setCompany(company);


				ll.add(c1);
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return ll;
	}


	//function to fetch city object by city id. City id is unique
	@Override
	public City fetchCityObj(int cid)
	{
		PreparedStatement pstmt = null;
		String sql = "select city , state , country from city_details where city_id = ?";

		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				City c = new City();
				c.setCity(rs.getString(1));
				c.setState(rs.getString(2));
				c.setCountry(rs.getString(3));
				return c;
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
		return null;
	}


	//function to edit contact by accepting edited contact values for particular user identified by username
	@Override
	public int editContact(Contact c1 , String username) {

		//fetching userId of current user in session by username
		User u1 = ud.getUserDetailsByUsername(username);
		String em = u1.getEmail();
		int uid = getUserId(em);

		//fetching contactId by email and username
		String email = c1.getEmail();
		int contId = getContactId(username , email);

		int r = 0;
		String sql = "update contact_details set first_name = ? , last_name = ? , email_id = ? , phone_no = ? ,  gender = ? , dob = ? , address = ? , city_id = ? , profile_image_path = ? , company = ? where user_id = ? and contact_id = ?";
		PreparedStatement pstmt = null;

		try
		{
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, c1.getFname());
			pstmt.setString(2, c1.getLname());
			pstmt.setString(3, c1.getEmail());
			pstmt.setString(4, c1.getPhone());
			pstmt.setString(5, c1.getGender());
			pstmt.setDate(6, c1.getDob());
			pstmt.setString(7, c1.getAddress());
			pstmt.setInt(8, cd.getCityId(c1.getCity1()));
			pstmt.setString(9, c1.getProfileImagePath());
			pstmt.setString(10, c1.getCompany());
			pstmt.setInt(11, uid);
			pstmt.setInt(12, contId);

			r = pstmt.executeUpdate();
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
		return r;
	}

	@Override
	public int deleteContact(String username , String email) {

		//fetching userId by username
		User u1 = ud.getUserDetailsByUsername(username);
		String em = u1.getEmail();
		int uid = getUserId(em);


		//fetching contactId by email and username
		int contId = getContactId(username , email);


		PreparedStatement pstmt1 = null;
		String sqlToDeleteContact = "delete from contact_details where user_id = ? and contact_id = ?";
		int r = 0;

		try
		{
			pstmt1 = conn.prepareStatement(sqlToDeleteContact);

			pstmt1.setInt(1, uid);
			pstmt1.setInt(2, contId);

			r = pstmt1.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt1.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return r;
	}

	///function to fetch contactId by username and email
	@Override
	public int getContactId(String username , String email) {
		String sqlToFetchContactId = "select contact_id from contact_details where email_id = ? and user_id = ?";
		PreparedStatement pstmt = null;
		int contId = 0;

		//fetching userId of current user in session by username
		User u1 = ud.getUserDetailsByUsername(username);
		String em = u1.getEmail();
		int uid = getUserId(em);

		try
		{
			pstmt = conn.prepareStatement(sqlToFetchContactId);
			pstmt.setString(1, email);
			pstmt.setInt(2, uid);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				contId = rs.getInt(1);
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
		return contId;
	}


	//function to view single contact with particular email for particular user identified by username
	@Override
	public Contact viewContact(String username , String email) {

		Contact c2 = new Contact();
		String sql = "select * from contact_details where user_id = ? and contact_id = ?";
		PreparedStatement pstmt = null;

		//fetching userId of current user in session by username
		User u1 = ud.getUserDetailsByUsername(username);
		String em = u1.getEmail();
		int uid = getUserId(em);

		//fetching contact Id of contact who user is referring to by email
		int contId = getContactId(username , email);



		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setInt(2, contId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				String FName = rs.getString(3);
				String LName = rs.getString(4);
				String emailId = rs.getString(5);
				String phNo = rs.getString(6);
				String gender = rs.getString(7);
				String company = rs.getString(8);
				Date dob = rs.getDate(9);
				String address = rs.getString(10);
				int cid = rs.getInt(11);
				String profileImagePath = rs.getString(12);

				City c = fetchCityObj(cid);

				c2.setFname(FName);
				c2.setLname(LName);
				c2.setEmail(emailId);
				c2.setPhone(phNo);
				c2.setGender(gender);
				c2.setDob(dob);
				c2.setAddress(address);
				c2.setCity1(c);
				c2.setProfileImagePath(profileImagePath);
				c2.setCompany(company);

				return c2;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	//function to check if contact already exists in user's phonebook
	@Override
	public boolean ifContactExists(String username, String email) {
		User u1 = ud.getUserDetailsByUsername(username);
		String em = u1.getEmail();
		int uid = getUserId(em);

		PreparedStatement pstmt = null;
		String sql = "select 1 from contact_details where user_id = ? and email_id=?";

		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
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

		return false;
	}


	//function to check if contact is a user of the system. returns null if Contact is not user. Other wise returns Contact obj

	@Override
	public Contact ifContactIsUser(String username, String email) {



		PreparedStatement pstmt = null;
		String sql = "select 1 from  user_details where user_id = ?";




		try
		{
			//fetching contact details on basis of email
			User u1 = ud.getUserDetailsByEmail(email);
			String em = u1.getEmail();
			int uid = getUserId(em);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				Contact c1 = new Contact();
				c1.setFname(u1.getFname());
				c1.setLname(u1.getLname());
				c1.setEmail(u1.getEmail());
				c1.setPhone(u1.getPhone());
				c1.setGender(u1.getGender());
				c1.setCompany(u1.getCompany());
				c1.setDob(u1.getDob());
				c1.setAddress(u1.getAddress());
				c1.setCity1(u1.getCity());
				c1.setProfileImagePath(u1.getProfileImagePath());

				return c1;
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

		return null;
	}



}