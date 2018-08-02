package TestAPI;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthenticationTest {

	static String baseurl="http://restapi.demoqa.com/authentication/CheckForAuthentication";
	@Test
	public void noAuthenticationPage()
	{
		RestAssured.baseURI = baseurl;

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get();

		System.out.println(response.statusCode());
		System.out.println(response.asString());
		assertEquals(response.statusCode(),401,"Invalid status code!");
	}
	
	@Test
	public void successfulAuthentication()
	{
		RestAssured.baseURI = baseurl;

		Header contentType = new Header("Authorization","Basic VG9vbHNRQTpUZXN0UGFzc3dvcmQ="); 
		
		RequestSpecification httpRequest = RestAssured.given().header(contentType);

		Response response = httpRequest.get();

		System.out.println(response.statusCode());
		System.out.println(response.asString());
		assertEquals(response.statusCode(),200,"Invalid status code!");
		
	}

}
