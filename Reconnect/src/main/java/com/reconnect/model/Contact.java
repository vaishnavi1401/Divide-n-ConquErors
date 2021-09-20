package com.reconnect.model;

public class Contact {

	private String fname, lname, email, dob, address, company, phone, gender;
	City city1=new City();

	public Contact() {

	}

	public Contact(String fname, String lname, String email, String dob, String address, String company, String phone, City city, String gender) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.company = company;
		this.phone = phone;
		this.city1=city;
		this.gender = gender;
	}
<<<<<<< Updated upstream

=======
	
>>>>>>> Stashed changes
	
	
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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