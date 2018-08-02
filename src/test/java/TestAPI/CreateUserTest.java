package TestAPI;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserTest {

	static String baseurl="https://reqres.in/";
	
	@Test(dataProvider = "New Users", dataProviderClass = DataProviders.class)
	public static void userTest(String dataProvidedName, String dataProvidedJob, int dataProvidedStatus)
	{
		RestAssured.baseURI = baseurl;

		Header contentType = new Header("Content-type","application/json; charset=UTF-8"); 

		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		
		httpRequest.body(Utills.createUserJson(dataProvidedName, dataProvidedJob)).post();
	
		Response response = httpRequest.request(Method.POST, "/api/users/");
		
		response.prettyPrint();
		System.out.println("Expected---------------"+ dataProvidedStatus+"----------Actual-----------"+response.statusCode());
		//assertEquals(response.statusCode(),dataProvidedStatus);
	}
}
