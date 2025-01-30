package com.rest.api.post;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class POSTAPIWithComplexOrgJson {

	//Nested JSON Type
	//Body Data Creation using Org.json library
	
	@Test
	public void POSTAPIwithComplexOrgJson() {
		
		
		
		JSONObject AddressInfo=new JSONObject();
		AddressInfo.put("H.No", "3726");
		AddressInfo.put("StreetName", "Augusta Lane");
		AddressInfo.put("Age", "38");
		
		JSONObject BasicInfo=new JSONObject();
		BasicInfo.put("FirstName", "Raghubir");
		BasicInfo.put("LastName", "Singh");
		BasicInfo.put("Age", "18");
		BasicInfo.put("id", "36936");
		BasicInfo.put("Address",AddressInfo);
		
	Response res= given()
			.contentType(ContentType.JSON)
			.body(BasicInfo)
			.when()
			.post("http://localhost:3000/friends");
	System.out.println(res.statusCode());
	System.out.println(res.asPrettyString());
		
	}

}
