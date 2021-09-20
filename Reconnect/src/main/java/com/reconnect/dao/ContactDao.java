package com.reconnect.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.reconnect.model.Contact;
import com.reconnect.model.User;
import com.reconnect.utility.DBUtils;

public class ContactDao implements ContactDaoInterface {
	
	Connection conn = null;
	public ContactDao()
	{
		conn = DBUtils.getConnection();
	}
	@Override
	public int addContact(Contact c1 , User u1) {
		
		int i1 = 0;
		
		try
		{
			PreparedStatement ps = conn.prepareStatement("insert into contact_details (user_id , first_name , last_name , email_id , phone_no , gender , dob , address , city_id , profile_image , creation_date) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			
			String em = u1.getEmail();
			String d = c1.getDob();
			Date d1 = Date.valueOf(d);
			
			
			ps.setInt(1, u1.getUserId(em));
			ps.setString(2, c1.getFname());
			ps.setString(3, c1.getLname());
			ps.setString(4, c1.getEmail());
			ps.setString(5, c1.getPhone());
			ps.setString(6, c1.getGender());
			ps.setDate(7, d1);
			ps.setString(8, c1.getAddress());
			
			
		}
		catch(SQLException e)
		{
			
		}
		
		return i1;
	}

}
