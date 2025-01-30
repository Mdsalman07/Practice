package com.rest.api.post;

import org.testng.annotations.Test;

import net.minidev.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class POSTAPIwithOrgJson {
 //Body Data Creation using Org.json library
 //Simple JSON	
	
	@Test
	public void POSTAPIwithJSONObj() {
		JSONObject BasicInfo=new JSONObject();
		BasicInfo.put("FirstName", "Raghubir");
		BasicInfo.put("LastName", "Singh");
		BasicInfo.put("Age", "18");
		BasicInfo.put("id", "3699");
		
	Response res= given()
			.contentType(ContentType.JSON)
			.body(BasicInfo)
			.when()
			.post("http://localhost:3000/friends");
	System.out.println(res.statusCode());
	System.out.println(res.asPrettyString());
		
	}
}
