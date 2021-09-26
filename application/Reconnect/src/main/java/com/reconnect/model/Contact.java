package com.reconnect.model;

import java.sql.Date;

public class Contact {

	private String fname, lname, email, address, company, gender, phone, profileImagePath;
	private Date dob;
	City city1;

	public Contact() {

	}

	public Contact(String fname, String lname, String email, Date dob, String address, String company, String phone, String gender, City city1, String profileImagePath) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.company = company;
		this.phone = phone;
		this.city1=city1;
		this.gender=gender;
		this.profileImagePath = profileImagePath;
	}



	@Override
	public String toString() {
		return "Contact [fname=" + fname + ", lname=" + lname + ", email=" + email + ", address=" + address
				+ ", company=" + company + ", gender=" + gender + ", phone=" + phone + ", profileImagePath="
				+ profileImagePath + ", dob=" + dob + ", city1=" + city1 + "]";
	}

	public String getProfileImagePath() {
		return profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public City getCity1() {
		return city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}