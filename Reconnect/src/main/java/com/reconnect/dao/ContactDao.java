package com.reconnect.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.reconnect.dao.util.ContactDaoInterface;
import com.reconnect.model.City;
import com.reconnect.model.Contact;
import com.reconnect.model.User;
import com.reconnect.utility.DBUtils;

public class ContactDao implements ContactDaoInterface {
	
	Connection conn = null;
	public ContactDao()
	{
		conn = DBUtils.getConnection();
	}

	public int addContact(Contact c1, User u1) throws FileNotFoundException {
		
		String sql = "insert into contact_details (user_id , first_name , last_name , email_id , phone_no , gender , dob , address , city_id , profileimage , creation_date , company) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		PreparedStatement pstmt = null;
		int i1 = 0;
		try
		{
			String em = u1.getEmail();
			Date d1 = (Date) c1.getDob();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
			FileInputStream picture=new FileInputStream(u1.getProfileImage().getAbsolutePath());
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getUserId(em));
			pstmt.setString(2, c1.getFname());
			pstmt.setString(3, c1.getLname());
			pstmt.setString(4, c1.getEmail());
			pstmt.setString(5 , c1.getPhone());
			pstmt.setString(6 , c1.getGender());
			pstmt.setDate(7, d1);
			pstmt.setString(8, c1.getAddress());
			pstmt.setInt(9, getCityId(c1.getCity1()));
			pstmt.setBinaryStream(10 , picture,(int)u1.getProfileImage().length());    
			pstmt.setTimestamp(11, timestamp);
			pstmt.setString(12, c1.getCompany());
			
			int rs = pstmt.executeUpdate();
			if (rs > 0) 
			{
				i1 = 1;
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
	
	public int getUserId(String email) {
		String sql = "select user_id from user_details where email_id = ?";
		PreparedStatement pstmt = null;
		try {
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
	
	public int getCityId(City c) {
		PreparedStatement pstmt = null;
		String sql = "select city_id from city_details where city=? and state=? and country=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCity());
			pstmt.setString(2, c.getState());
			pstmt.setString(3, c.getCountry());
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
	
	public List<Contact> viewAllContacts(User u1) {
		
		List<Contact> ll = new ArrayList<Contact>();
		String sql = "select * from contact_details where user_id = ?";
		PreparedStatement pstmt = null;
		//String em = u1.getEmail();

		try
		{
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, getUserId(em));
			pstmt.setInt(1, 300007);
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
				//String d = dateFormat.format(dob);
				
				String address = rs.getString(10);
				int cid = rs.getInt(11);
				//for image 12
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
				// for image
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

	public int editContact(Contact c1, User u1) {
		
		String em = u1.getEmail();
		int uid = getUserId(em);
		int contId = getContactId(c1 , u1);
		int r = 0;
		String sql = "update contact_details set first_name = ? , last_name = ? , email_id = ? , phone_no = ? ,  gender = ? , dob = ? , address = ? , city_id = ? , profile_image = ? , company = ? where user_id = ? and contact_id = ?";
		PreparedStatement pstmt = null;

		try
		{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c1.getFname());
			pstmt.setString(2, c1.getLname());
			pstmt.setString(3, c1.getEmail());
			pstmt.setString(4, c1.getPhone());
			pstmt.setString(5, c1.getGender());
			pstmt.setDate(6, (Date) c1.getDob());
			pstmt.setString(7, c1.getAddress());
			pstmt.setInt(8, getCityId(c1.getCity1()));
			//for image
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
		return 0;
	}

	public int deleteContact(Contact c1, User u1) {
		
		String em = u1.getEmail();
		int uid = getUserId(em);
		int contId = getContactId(c1 , u1);
		PreparedStatement pstmt = null;
		String sql = "delete from contact_details where user_id = ? and contact_id = ?";
		int r = 0;
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			pstmt.setInt(2, contId);
			
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

	public int getContactId(Contact c1 , User u1) {
		String sql = "select contact_id from contact_details where first_name = ? and last_name = ? and email_id = ? and phone_no = ? and user_id = ?";
		PreparedStatement pstmt = null;
		String em = u1.getEmail();
		int uid = getUserId(em);		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c1.getFname());
			pstmt.setString(2, c1.getLname());
			pstmt.setString(3, c1.getEmail());
			pstmt.setString(4, c1.getPhone());
			pstmt.setInt(5, uid);
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

	public Contact viewContact(Contact c1, User u1) {

		Contact c2 = new Contact();
		String sql = "select * from contact_details where user_id = ? and contact_id = ?";
		PreparedStatement pstmt = null;
		String em = u1.getEmail();
		int uid = getUserId(em);
		int contId = getContactId(c1 , u1);
		
		try
		{
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, uid);
			pstmt.setInt(2, contId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				String fName = rs.getString(3);
				String lName = rs.getString(4);
				String emailId = rs.getString(5);
				String phNo = rs.getString(6);
				String gender = rs.getString(7);
				String company = rs.getString(8);
				Date dob = rs.getDate(9);
				String address = rs.getString(10);
				int cid = rs.getInt(11);
				//for image 12
				
				City c = fetchCityObj(cid);
				
				c2.setFname(fName);
				c2.setLname(lName);
				c2.setEmail(emailId);
				c2.setPhone(phNo);
				c2.setGender(gender);
				c2.setDob(dob);
				c2.setAddress(address);
				c2.setCity1(c);
				// for image
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

}
