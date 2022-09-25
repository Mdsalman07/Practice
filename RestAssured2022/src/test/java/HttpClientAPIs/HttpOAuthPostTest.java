package HttpClientAPIs;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class HttpOAuthPostTest {
	
	public static void twitterApiOAuthTest() {
		
	String consumerKey=	"j3wZbJqfgFh2oyiqmEA7SkBQx";
	String consumerSecret=	"fGgpImfXreJWMr2IVwRiZZ4H2qLBsSrEZnmh50DW7JbnGiPK0C";
	String accessToken=	"2958446370-Jo5M0IJQyj2MPaEMwyyDWyIvOwRNFAJL6AsRKbz";
	String accessTokenSecret="QEIAL1AbZqaVpTskGCRCCaOtLY3QoDHAcZvqGN2F80RWl";
	
OAuthConsumer consumer=	new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
consumer.setTokenWithSecret(accessToken, accessTokenSecret);

CloseableHttpClient httpClient=	HttpClientBuilder.create().build();

HttpPost postRequest=new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=heythistweetfromhttpAPI");
try {
	consumer.sign(postRequest);
} catch (OAuthMessageSignerException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (OAuthExpectationFailedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (OAuthCommunicationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

CloseableHttpResponse response=null;
try {
	response=httpClient.execute(postRequest);
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

int StatusCode=response.getStatusLine().getStatusCode();
System.out.println(StatusCode);
Assert.assertEquals(StatusCode, 200);

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

System.out.println(responseBody);

HttpGet getRequest=new HttpGet("https://api.twitter.com/1.1/statuses/show.json?id=1202261078392131584");
try {
	consumer.sign(getRequest);
} catch (OAuthMessageSignerException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (OAuthExpectationFailedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (OAuthCommunicationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
	response=httpClient.execute(getRequest);
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	int StatusCode1=response.getStatusLine().getStatusCode();
	System.out.println(StatusCode1);
	Assert.assertEquals(StatusCode1, 200);
	
	 httpEntity=response.getEntity();
	 responseBody=null;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		twitterApiOAuthTest();

	}

}
