package HttpClientAPIs;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

//import io.restassured.path.json.JsonPath;

public class GetUserAPI {
	
	@Test
	public void getUserTest() {
	CloseableHttpClient httpClient=	HttpClientBuilder.create().build();
	CloseableHttpResponse response=null;
	
	//1.Create a get request with URL
		HttpGet getRequest=new HttpGet("https://gorest.co.in/public-api/users");
		
		//2.add Headers
		getRequest.addHeader("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae");
		
		//3.execute the api
		try {
		response=httpClient.execute(getRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4.get the StatusCode
		int StatusCode=response.getStatusLine().getStatusCode();
		System.out.println(StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		//5.get the response body
		
	HttpEntity httpEntity=	response.getEntity();
	String responseBody=null;
	try {
		responseBody=EntityUtils.toString(httpEntity);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		//get json value using restassured JsonPath
//		JsonPath js=new JsonPath(responseBody);
//		System.out.println(js.getString("_meta.success"));
		
		//get json value from jayway JsonPath API:
	Object document=Configuration.defaultConfiguration().jsonProvider().parse(responseBody);
	List<Boolean> result=JsonPath.read(document," $..success");
	Assert.assertTrue(result.get(0));
	}
	
	}
	
	
	

}
