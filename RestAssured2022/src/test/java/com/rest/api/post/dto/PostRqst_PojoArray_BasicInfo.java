package com.rest.api.post.dto;

public class PostRqst_PojoArray_BasicInfo {
	private String FirstName;
	private String LastName;
	private String Designation;
	private String Id;
	private String MentorName;
	private String CourseName;
	private PojoComplex_Address[] Address;
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMentorName() {
		return MentorName;
	}
	public void setMentorName(String mentorName) {
		MentorName = mentorName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public PojoComplex_Address[] getAddress() {
		return Address;
	}
	public void setAddress(PojoComplex_Address[] address) {
		Address = address;
	}

}
