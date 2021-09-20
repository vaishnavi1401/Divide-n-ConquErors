package com.reconnect.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.reconnect.model.Admin;
import com.reconnect.utility.DBUtils;


public class AdminDaoImpl implements AdminDao {
	static Document doc;
	static File fXmlFile;
	
	static DocumentBuilder dBuilder;
	static Admin admin;
	private static Connection con;
	private static PreparedStatement count_users,uget,ugetloc;
	static {
		fXmlFile = new File("D:\\code_fury_hsbc\\Divide-n-ConquErors\\Reconnect\\src\\main\\java\\com\\reconnect\\dao\\admin.xml");
		

		try {
			DocumentBuilderFactory dbFactory;dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			//System.out.println(fXmlFile);
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			String nm, em, us_name, pass;
			String p_no;
			String pic_path;
			nm = doc.getElementsByTagName("name").item(0).getTextContent();
			em = doc.getElementsByTagName("email").item(0).getTextContent();
			p_no = doc.getElementsByTagName("phone_number").item(0).getTextContent();
			pic_path = doc.getElementsByTagName("pic_path").item(0).getTextContent();
			us_name = doc.getElementsByTagName("username").item(0).getTextContent();
			pass = doc.getElementsByTagName("passward").item(0).getTextContent();
			// System.out.println(nm);
			admin = new Admin(nm, em, p_no, pic_path, us_name, pass);
			System.out.println("STATIC ADMIN"+admin);
			con=DBUtils.getConnection();
			count_users=con.prepareStatement("SELECT COUNT(*) AS rowcount FROM user_details");
			uget=con.prepareStatement("SELECT user_id,city_id from user_details ");
			ugetloc=con.prepareStatement("Select * from city_details where city_id=?");



		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// validate function for admin creditionals
	@Override
	public Admin adminLogin(String username, String passward) {
		System.out.println("ADMIN IN DAO"+admin);
		System.out.println(admin.getName()+" "+admin.getPassward()+"username"+username+"  "+passward);
		if (admin.getName().equals(username) && (admin.getPassward().equals(passward)))
			{
			
			return admin;}
		else
			return null;

	}

	@Override
	public Admin getAdminDetails() {
	return admin;
	}

	@Override
	public void viewDisabledUser() {


	}

	@Override
	public void viewDeletedUser() {


	}

	@Override
	public int numOfUser() {
		try {
			ResultSet r=count_users.executeQuery();
			//System.out.println(r.getInt(0));
			r.next();
			return r.getInt("rowcount");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Map<Integer, String> viewAllUser() {
		Map<Integer,String> m = new HashMap();
			ResultSet r;
			try {
				r = uget.executeQuery();

				while(r.next())
				{


				int r_id=r.getInt("city_id");

				ugetloc.setInt(1, r_id);
				ResultSet res=ugetloc.executeQuery();
				res.next();
				String s;
				s=res.getString("city")+","+ res.getString("State")+","+res.getString("Country");
				m.put(r.getInt("user_id"), s);
				}
				return m;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		return null;
	}
}






