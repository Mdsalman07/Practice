package com.rest.api.authentications;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class OAuthAPITest {
	
	@Test
	public void TwitterStatusAPI_OAuth1_Test() {
		
		RequestSpecification request=
				RestAssured.given()
				.auth()
				.oauth("j3wZbJqfgFh2oyiqmEA7SkBQx",
						"fGgpImfXreJWMr2IVwRiZZ4H2qLBsSrEZnmh50DW7JbnGiPK0C",
						"2958446370-Jo5M0IJQyj2MPaEMwyyDWyIvOwRNFAJL6AsRKbz",
						"QEIAL1AbZqaVpTskGCRCCaOtLY3QoDHAcZvqGN2F80RWl");
	    Response response=request.post("https://api.twitter.com/1.1/statuses/update.json?status=hey this tweet from Rest Assured API");
	    int statusCode=response.getStatusCode();
	    System.out.println(response.getStatusCode());
	    Assert.assertEquals(statusCode, 200);
	    System.out.println(response.prettyPrint());
		
	}

}
