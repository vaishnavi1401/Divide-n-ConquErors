package com.reconnect.model;

public class Admin {
private String name;
private String email;
private String phone_number;
private String username;
private String passward;

private String pic_path;
public Admin(String name, String email, String phone_number, String username, String passward) {

	super();
	this.name = name;
	this.email = email;
	this.phone_number = phone_number;
	this.username = username;
	this.passward = passward;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassward() {
	return passward;
}
public void setPassward(String passward) {
	this.passward = passward;
}
@Override
public String toString() {
	return "Admin [name=" + name + ", email=" + email + ", phone_number=" + phone_number + ", username=" + username
			+ ", passward=" + passward+ "]";
}

}
