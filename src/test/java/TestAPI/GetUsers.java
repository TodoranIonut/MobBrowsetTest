package TestAPI;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUsers {

	static String baseurl="https://reqres.in/";


	public void getUserTest()
	{

		RestAssured.baseURI = baseurl;

		Header contentType = new Header("Content-type","application/json; charset=UTF-8"); 

		RequestSpecification httpRequest = RestAssured.given().header(contentType);

		Response response = httpRequest.request(Method.GET, "/api/users/2");

		System.out.println(response.getStatusCode());//status code
		System.out.println(response.getBody().asString());//prind long string
		System.out.println(response.asString());
		//System.out.println(response.prettyPrint());//print body

		assertEquals(response.getStatusCode(), 200, "Invalid Status Code!");
		assertEquals(response.asString().contains("Janet"),true);
		assertEquals(response.getBody().asString().contains("Janet"),true);
		System.out.println(Utills.getUserDataFromJson(response.asString() , "first_name"));
		assertEquals(Utills.getUserDataFromJson(response.asString() , "first_name") , "Janet", "Invalid Name");
		assertEquals(Utills.getUserDataFromJson(response.asString() , "last_name") , "Weaver", "Invalid Last Name");
	}


	public void getUserTestNG()
	{
		RestAssured.baseURI = baseurl;

		Header contentType = new Header("Content-type","application/json; charset=UTF-8"); 

		RequestSpecification httpRequest = RestAssured.given().header(contentType);

		Response response = httpRequest.request(Method.GET, "/api/users");
		
		assertEquals(response.getStatusCode(),200);
	}
	
	public void getUserTestAssured()
	{
		RestAssured.baseURI = baseurl;

		Header contentType = new Header("Content-type","application/json; charset=UTF-8"); 

		RequestSpecification httpRequest = RestAssured.given().header(contentType);

		RestAssured.given().header(contentType).when().get("/api/users/2").then().statusCode(HttpStatus.SC_OK);
	}
	
	public void getUserList()
	{
		RestAssured.baseURI = baseurl;

		Header contentType = new Header("Content-type","application/json; charset=UTF-8"); 

		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		
		Response response = httpRequest.request(Method.GET, "/api/users");
		
		int total = Integer.parseInt((Utills.getUserDataFromJson(response.asString() , "total")).toString());
		
		System.out.println(total);
		
		for(int i=1;i<=total;i++)
		{
			response = httpRequest.request(Method.GET, "/api/users/"+i);
			assertEquals((Utills.getUserDataFromJson(response.asString() , "id").toString()),Integer.toString(i));
			//System.out.println((Utills.getUserDataFromJson(response.asString() , "first_name").toString()));
		}
		
		List<String> firstNameList = new ArrayList<String>();
		List<String> lastNameList = new ArrayList<String>();
		List<String> compLastNameList = Arrays.asList("Bluth", "Weaver", "Wong", "Holt", "Morris","Ramos","Lawson","Ferguson","Funke","Fields","Edwards","Howell");
		List<String> compFirstNameList = Arrays.asList("George", "Janet", "Emma", "Eve", "Charles","Tracey","Michael","Lindsay","Tobias","Byron","George","Rachel");
		
		for(int i=1;i<=total;i++)
		{
			response = httpRequest.request(Method.GET, "/api/users/"+i);
			String nume = Utills.getUserDataFromJson(response.asString() , "first_name").toString();
			nume = nume.substring(1,nume.length()-1);
			firstNameList.add(nume);
			String prenume = Utills.getUserDataFromJson(response.asString() , "last_name").toString();
			prenume = prenume.substring(1,prenume.length()-1);
			lastNameList.add(prenume);
		}
	
		for(int i=0;i<firstNameList.size();i++)
		{
			assertEquals(firstNameList.get(i),compFirstNameList.get(i));
			assertEquals(lastNameList.get(i),compLastNameList.get(i));
		}
	}
	
	@Test
	public void putUser()
	{
		RestAssured.baseURI = baseurl;

		Header contentType = new Header("Content-type","application/json; charset=UTF-8"); 

		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		
		httpRequest.body(Utills.createUserJson("Alexel", "caraus")).post();
	
		Response response = httpRequest.request(Method.POST, "/api/users/");
		
		response.prettyPrint();
		assertEquals(response.statusCode(),201);
		String nume = Utills.getUserDataFromJson(response.asString(),"name").toString();
		nume = nume.substring(1,nume.length()-1);
		String job = Utills.getUserDataFromJson(response.asString(),"job").toString();
		job = job.substring(1,job.length()-1);
		assertEquals(nume , "Alexel");
		assertEquals(job ,  "caraus");

	}

}
