package HttpClientAPIs;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.post.User;

public class PostUserAPI {
	
	@Test
	public void createUserAPITest() {
		
		CloseableHttpClient httpClient=	HttpClientBuilder.create().build();
		CloseableHttpResponse response=null;
		
		//1.Create a get request with URL
			HttpPost postRequest=new HttpPost("https://gorest.co.in/public-api/users");
			
			//2.add Headers
			postRequest.addHeader("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae");
			postRequest.addHeader("Content-Type", "application/json");
			postRequest.addHeader("accept", "application/json");
			
			//3.convert pojo to Json using JacksonApi(serialization):	
			User user = new User("Nisha", "John", "NishaJohn", "female", "01-01-1990", "nisha1@gmail.com",
					"12,avenue,SFO,CA", "active");
			
			// convert Java pojo to json --Serialization---Jackson API
			ObjectMapper mapper = new ObjectMapper();
			String userJson = null;
			try {
				userJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(userJson);
			
			StringEntity userEntity=null;
			
			try {
				userEntity=new StringEntity(userJson);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//4 .add the JsON To the request
			postRequest.setEntity(userEntity);
			//5.execute the api
			try {
			response=httpClient.execute(postRequest);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//6.get the StatusCode
			int StatusCode=response.getStatusLine().getStatusCode();
			System.out.println(StatusCode);
			Assert.assertEquals(StatusCode, 200);
			
			
			//7.get the response body
			
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

			
		
	}

	}
}
