package com.rest.api.get;


import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
public static Response doGet(String contentType,String baseURI,String basePath,String token,Map<String,String> paramsMap,boolean log) {
	setBaseURI(baseURI);
	RequestSpecification request=createRequest(contentType, token, paramsMap,log);
	return getResponse("GET", request, basePath);
	}
	
	public static void setBaseURI(String baseURI) {
		RestAssured.baseURI=baseURI;
		}
	
	public static RequestSpecification createRequest(String contentType,String token,Map<String,String> paramsMap,boolean log) {
		RequestSpecification request;
		if(log) {
		request=RestAssured.given().log().all();
		}
		else {
			request=RestAssured.given();
		}
		if(token!=null) {
			request.header("Authorization","Bearer "+token);
		}
		if(!(paramsMap==null)) {
			request.queryParams(paramsMap);
		}
		
		if(contentType.equalsIgnoreCase("JSON")) {
			request.contentType(ContentType.JSON);
		}
		else if(contentType.equalsIgnoreCase("XML")) {
			request.contentType(ContentType.XML);
		}
		return request;
		
	}
	
	public static Response getResponse(String HTTPMethod,RequestSpecification request,String basePath) {
		return executeAPI( HTTPMethod,request, basePath);
	}
	
public static Response executeAPI(String HTTPMethod,RequestSpecification request,String basePath) {
	Response response=null;
	switch (HTTPMethod) {
	case "GET":
		response =request.get(basePath);   
		break;
	case "POST":
		response =request.get(basePath);   
		break;
	case "PUT":
		response =request.get(basePath);   
		break;
	case "DELETE":
		response =request.get(basePath);   
		break;

	default:
		System.out.println("Please pass correct http method");
		break;
	}
	return response;
		
	}
	
	

}
