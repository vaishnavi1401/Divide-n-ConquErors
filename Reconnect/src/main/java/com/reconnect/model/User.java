package com.reconnect.model;

import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

public class User {

	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String gender;
	private Date dob;
	private String address;
	private String company;
	private Timestamp creationDate; // initialize
	private File profileImage;
	private int userId;
	private City city;
	private String username;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getFname() {
		return fname;
	}

	public int getUserId() {
		return userId;
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

	public void setDob(Date birthday) {
		this.dob = birthday;
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
		this.creationDate = creationDate; // work
	}

	public File getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(File image) {
		this.profileImage = image;
	}

	public User(String username, String fname, String lname, City city) {
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
	}

	public User(String fname, String lname, String email, String phone, String gender, Date dob, String address,
			String company, City city) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.company = company;
		this.city = city;
	}

	public User() {
	}

}
