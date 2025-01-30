package HttpClientAPIs;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest {
	
	@Test
	public void deleteUserTest() {
		
		CloseableHttpClient httpClient=	HttpClientBuilder.create().build();
		CloseableHttpResponse response=null;
		
		//1.Create a get request with URL
			HttpDelete deleteRequest=new HttpDelete("https://gorest.co.in/public-api/users");
			
			//2.add Headers
			deleteRequest.addHeader("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae");
			
			//3.execute the api
			try {
			response=httpClient.execute(deleteRequest);
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
		}
		
	}

}
