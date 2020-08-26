package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Casestudyex2get2 
{

	public static void main(String[] args) 
	
	{
	   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	   	//RequestSpecification req=RestAssured.given();

	   	Response res=RestAssured.given().get("/employee/28");
	
	   	System.out.println(res.getStatusLine());
	   	System.out.println(res.getHeader("Content-Type"));
	   	System.out.println(res.getBody().asString());



	}

}
