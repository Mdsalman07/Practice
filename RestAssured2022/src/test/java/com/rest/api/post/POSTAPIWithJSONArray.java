package com.rest.api.post;

import org.testng.annotations.Test;

import com.rest.api.post.dto.PojoComplex_Address;
import com.rest.api.post.dto.PostRqst_PojoArray_BasicInfo;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTAPIWithJSONArray {
	
	@Test
	public void PostWithArrayJSON() {
		PojoComplex_Address[] Address=new  PojoComplex_Address[2]; //create a reference of array
		
		Address[0]=new PojoComplex_Address();
		Address[1]=new PojoComplex_Address();
		
		Address[0].setH_No("3726/10");
		Address[0].setStreet("Augusta Lane");
		Address[0].setZipCode("ME46DG");
		
		Address[1].setH_No("406");
		Address[1].setStreet("Sadle Lake");
		Address[1].setZipCode("CA49AB");
		
		PostRqst_PojoArray_BasicInfo basicinfo=new PostRqst_PojoArray_BasicInfo();
		basicinfo.setFirstName("Raghubir");
		basicinfo.setLastName("Singh");
		basicinfo.setCourseName("API Testing");
		basicinfo.setDesignation("Test Lead");
		basicinfo.setMentorName("Deepak Kumar");
		basicinfo.setId("3696");
		basicinfo.setAddress(Address);
		
	RequestSpecification request=RestAssured.given().contentType(ContentType.JSON).body(basicinfo).when();
	Response response=request.post("http://localhost:3000/friends");
	System.out.println(response.getStatusCode());
	System.out.println(response.asString());
	}

	
}
