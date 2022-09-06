package com.rest.api.post;
//POJO Template
public class User {
	//Class vars
	private String first_name;
	private String last_name;
	private String name;
	private String gender;
	private String dob;
	private String email;
	private String address;
	private String status;
	
	
	//Constructor
	public User(String first_name, String last_name, String name, String gender, String dob, String email,
			String address, String status) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.status = status;
	}
    //getters and setters
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
