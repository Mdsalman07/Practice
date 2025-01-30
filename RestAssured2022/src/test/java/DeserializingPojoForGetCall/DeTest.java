package DeserializingPojoForGetCall;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeTest {
	
	@Test
	public void DeserTest() {
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2"; 
		ListUsersPOJO pojo=	RestAssured.given().when().get().as(ListUsersPOJO.class);
		System.out.println(pojo.toString());
		//Let say u need to access DataPojo
		List<DataPojo> list = pojo.getData();
		for(int i=0;i<list.size();i++) {
			System.out.println("This is my"+i+"element"+list.get(i));
		}
		
	}

}
