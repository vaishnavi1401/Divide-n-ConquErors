package com.reconnect.model;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;

import com.reconnect.dao.UserDao;

<<<<<<< Updated upstream
	private String fname;
	private String lname;
	private String email;
=======
public class User {
	
	//private int userId;
	private String fname; 
	private String lname; 
	private String email; 
>>>>>>> Stashed changes
	private String phone;
	private String gender;
	private Date dob;
	private String address;
	private String company;
	private Timestamp creationDate; //initialize
<<<<<<< Updated upstream
	private File profileImage;

=======
	private File profileImage; 
	
	UserDao ud1 = new UserDao();
	
	
	public int getUserId(String email) {
		return ud1.getUserIdFromUserDao(email);
	}
	
>>>>>>> Stashed changes
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate; //work
	}
	public File getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(File profileImage) {
		this.profileImage = profileImage;
	}





}