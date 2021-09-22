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

import com.reconnect.dao.util.AdminDao;
import com.reconnect.model.Admin;
import com.reconnect.utility.DBUtils;

public class AdminDaoImpl implements AdminDao {
	static Document doc;
	static File fXmlFile;

	static DocumentBuilder dBuilder;
	static Admin admin;
	private static Connection con;
	private static PreparedStatement count_users, uget, ugetloc,ugetcr, ugetlastlogin,ugetdel, ugetdelloc,udel,ugetblock,ugetid,ugetcredid;
	static {
		fXmlFile = new File("assets/admin.xml");

		try {
			DocumentBuilderFactory dbFactory;
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			// System.out.println(fXmlFile);
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
			System.out.println("STATIC ADMIN" + admin);
			con = DBUtils.getConnection();
			count_users = con.prepareStatement("SELECT COUNT(*) AS rowcount FROM user_details");
			uget = con.prepareStatement("SELECT user_id,city_id,credential_id from user_details ");
			ugetloc = con.prepareStatement("Select * from city_details where city_id=?");
			ugetcr = con.prepareStatement("Select * from credentials where credential_id=?");
			udel=con.prepareStatement("delete from user_details where user_id=?");
			ugetblock=con.prepareStatement("select blocked_who from blocked_user GROUP BY blocked_who HAVING COUNT(*) > 0 ");
			ugetid = con.prepareStatement("SELECT city_id,credential_id from user_details  where user_id=? ");
			ugetlastlogin=con.prepareStatement("SELECT credential_id,username FROM credentials WHERE last_login < NOW() - INTERVAL 1 MONTH");
			ugetcredid=con.prepareStatement("SELECT city_id from user_details  where credential_id=?");
				

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
	public Admin adminLogin(String username, String passward) {
		System.out.println("ADMIN IN DAO" + admin);
		System.out.println(admin.getName() + " " + admin.getPassward() + "username" + username + "  " + passward);
		if (admin.getName().equals(username) && (admin.getPassward().equals(passward))) {

			return admin;
		} else
			return null;

	}

	public Admin getAdminDetails() {
		return admin;
	}



	public int numOfUser() {
		try {
			ResultSet r = count_users.executeQuery();
			// System.out.println(r.getInt(0));
			r.next();
			return r.getInt("rowcount");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Map<String, String> viewDisabledUser() {
		Map<String, String> m = new HashMap();
		
		try {
			
			ResultSet res2=ugetblock.executeQuery();

			while (res2.next()) {
				int block_id=res2.getInt("blocked_who");
				System.out.println(block_id);
				ugetid.setInt(1, block_id);
				ResultSet r =ugetid.executeQuery();
				r.next();
				int r_id = r.getInt("city_id");
				int cr_id=r.getInt("credential_id");
				
				ugetloc.setInt(1, r_id);
				ResultSet res = ugetloc.executeQuery();
				res.next();
				
				
				String s;
				s = res.getString("city") + "," + res.getString("State") + "," + res.getString("Country");
				ugetcr.setInt(1, cr_id);
				ResultSet res1 = ugetcr.executeQuery();
				res1.next();
				
				m.put(res1.getString("username"), s);
			
			}
			return m;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	public Map<String, String> viewAllUserInfo() {
		Map<String, String> m = new HashMap();
		ResultSet r;
		try {
			r = uget.executeQuery();

			while (r.next()) {

				int r_id = r.getInt("city_id");
				int cr_id=r.getInt("credential_id");
				
				ugetloc.setInt(1, r_id);
				ResultSet res = ugetloc.executeQuery();
				res.next();
				
				ugetcr.setInt(1, cr_id);
				ResultSet res1 = ugetloc.executeQuery();
				res1.next();

				String s;
				s = res.getString("city") + "," + res.getString("State") + "," + res.getString("Country");
				m.put(res1.getString("username"), s);
			
			}
			return m;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;

	}
	public void deleteUser(int u_id) {
		
		try {
			udel.setInt(1, u_id);
			ResultSet r=udel.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void adminLogout() {
		// TODO Auto-generated method stub

	}

	public Map<String, String> viewUserToDelete() {
Map<String, String> m = new HashMap();
		
		try {
			
			ResultSet res2=ugetlastlogin.executeQuery();

			while (res2.next()) {
				
				int credential_id=res2.getInt("credential_id");
				ugetcredid.setInt(1,credential_id);
				ResultSet r =ugetcredid.executeQuery();
				r.next();
				int r_id = r.getInt("city_id");
				
				
				ugetloc.setInt(1, r_id);
				ResultSet res = ugetloc.executeQuery();
				res.next();
				
				
				String s;
				s = res.getString("city") + "," + res.getString("State") + "," + res.getString("Country");
				
				
				m.put(res2.getString("username"), s);
			
			}
			return m;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return m;
	}
}
