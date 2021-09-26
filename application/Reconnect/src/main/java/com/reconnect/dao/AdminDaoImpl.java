package com.reconnect.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.reconnect.dao.util.AdminDao;
import com.reconnect.dao.util.UserDaoInterface;
import com.reconnect.model.Admin;
import com.reconnect.utility.DBUtils;

public class AdminDaoImpl implements AdminDao {
	static Document doc;
	static File fXmlFile;

	static DocumentBuilder dBuilder;
	static Admin admin;
	private static Connection con;
	static UserDaoInterface user_dao = new UserDao();
	private static PreparedStatement count_users, uget, ugetloc, ugetcr, ugetlastlogin, ugetdel, ugetdelloc, udel,
			ugetblock, ugetid, ugetcredid, ugetuserid, insertdisablestat;
	static {

		fXmlFile = new File("D:\\code_fury_hsbc\\Divide-n-ConquErors\\application\\Reconnect\\src\\main\\webapp\\assets\\admin.xml");




		try {
			DocumentBuilderFactory dbFactory;
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			// System.out.println(fXmlFile);
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			String nm, em, us_name, pass;
			String p_no;
			String pic_path = "";
			nm = doc.getElementsByTagName("name").item(0).getTextContent();
			em = doc.getElementsByTagName("email").item(0).getTextContent();
			p_no = doc.getElementsByTagName("phone_number").item(0).getTextContent();

			//pic_path = doc.getElementsByTagName("pic_path").item(0).getTextContent();>>>>>> e1585f11a1ada8c9d4b773e935447e0819f20cba
			us_name = doc.getElementsByTagName("username").item(0).getTextContent();
			pass = doc.getElementsByTagName("passward").item(0).getTextContent();
			// System.out.println(nm);
			admin = new Admin(nm, em, p_no, us_name, pass);
			// System.out.println("STATIC ADMIN" + admin);
			con = DBUtils.getConnection();
			count_users = con.prepareStatement("SELECT COUNT(*) AS rowcount FROM user_details");
			uget = con.prepareStatement("SELECT user_id,city_id,credential_id from user_details ");
			ugetloc = con.prepareStatement("Select * from city_details where city_id=?");
			ugetcr = con.prepareStatement("Select * from credentials where credential_id=?");
			udel = con.prepareStatement("delete from user_details where user_id=?");
			ugetblock = con
					.prepareStatement("select blocked_who from blocked_user GROUP BY blocked_who HAVING COUNT(*) > 0 ");
			ugetid = con.prepareStatement("SELECT city_id,credential_id from user_details  where user_id=? ");
			ugetlastlogin = con.prepareStatement(
					"SELECT credential_id,username FROM credentials WHERE last_login < NOW() - INTERVAL 1 MONTH");
			ugetcredid = con.prepareStatement("SELECT city_id,user_id  from user_details  where credential_id=?");
			ugetuserid = con.prepareStatement("SELECT credential_id  from credentials  where username=?");
			insertdisablestat = con.prepareStatement("INSERT INTO disable_users VALUES (?,?,?)");

		} catch (SAXException e) {

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

		if (admin.getUsername().equals(username) && (admin.getPassward().equals(passward))) {
			System.out.println("DONE");
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

			ResultSet res2 = ugetblock.executeQuery();

			while (res2.next()) {
				int block_id = res2.getInt("blocked_who");
				// System.out.println(block_id);
				ugetid.setInt(1, block_id);
				ResultSet r = ugetid.executeQuery();
				r.next();
				int r_id = r.getInt("city_id");
				int cr_id = r.getInt("credential_id");

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
				int cr_id = r.getInt("credential_id");

				ugetloc.setInt(1, r_id);
				ResultSet res = ugetloc.executeQuery();
				res.next();

				ugetcr.setInt(1, cr_id);
				ResultSet res1 = ugetcr.executeQuery();
				res1.next();
				String result = res1.getString("username");

				String s;
				s = res.getString("city") + "," + res.getString("State") + "," + res.getString("Country");
				m.put(result, s);

			}
			return m;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;

	}

	
	public Map<String, String> viewUserToDelete() {
		Map<String, String> m = new HashMap();

		try {

			ResultSet res2 = ugetlastlogin.executeQuery();

			while (res2.next()) {

				int credential_id = res2.getInt("credential_id");
				String username = res2.getString("username");
				ugetcredid.setInt(1, credential_id);
				ResultSet r = ugetcredid.executeQuery();
				r.next();
				int r_id = r.getInt("city_id");

				ugetloc.setInt(1, r_id);
				ResultSet res = ugetloc.executeQuery();
				res.next();

				String s;
				s = res.getString("city") + "," + res.getString("State") + "," + res.getString("Country");

				m.put(username, s);

			}
			return m;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return m;
	}

	public boolean deleteUser(String[] username) {
		PreparedStatement del_disable, del_blocked, del_friends, del_crediantials, del_user, del_contacts;
		try {
			del_disable = con.prepareStatement("DELETE FROM Disable_users WHERE disable_id=?");
			del_blocked = con.prepareStatement("DELETE FROM blocked_user WHERE blocked_by=? or blocked_who=?");
			del_friends = con.prepareStatement("DELETE FROM friend_details WHERE friend_one=? or friend_two=?");
			del_contacts = con.prepareStatement("DELETE FROM contact_details WHERE user_id=?");
			del_user = con.prepareStatement("DELETE FROM user_details WHERE user_id=?");
			del_crediantials = con.prepareStatement("DELETE FROM credentials WHERE username=?");
			List<Integer> user_id = new ArrayList<Integer>();
			for (String s : username) {
				int id = user_dao.getUserId(s);
				user_id.add(id);
			}
			for (Integer u : user_id) {
				del_disable.setInt(1, u);
				del_blocked.setInt(1, u);
				del_blocked.setInt(2, u);
				del_friends.setInt(1, u);
				del_friends.setInt(2, u);
				del_contacts.setInt(1, u);
				del_user.setInt(1, u);

				del_disable.addBatch();
				del_blocked.addBatch();
				del_contacts.addBatch();
				del_friends.addBatch();
				del_user.addBatch();

			}
			del_disable.executeBatch();
			del_blocked.executeBatch();
			del_contacts.executeBatch();
			del_friends.executeBatch();
			del_user.executeBatch();
			for (String s : username) {
				del_crediantials.setString(1, s);
				del_crediantials.addBatch();
			}
			del_crediantials.executeBatch();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	
	public boolean DisableUser(String[] username) {

		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		String reason = "Blocked-3";

		try {

			List<Integer> cred_id = new ArrayList<Integer>();
			List<Integer> user_id = new ArrayList<Integer>();
			for (String s : username) {
				int id = user_dao.getUserId(s);
				// System.out.println(id);
				user_id.add(id);
			}
			System.out.println(user_id);

			for (Integer u : user_id) {
				insertdisablestat.setInt(1, u);
				insertdisablestat.setTimestamp(2, date);
				insertdisablestat.setString(3, reason);
				insertdisablestat.executeUpdate();

			}
			PreparedStatement prep = con.prepareStatement(" DELETE FROM blocked_user WHERE blocked_who=?");
			for (Integer u : user_id) {
				prep.setInt(1, u);
				prep.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
