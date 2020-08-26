package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Casestudyex5delete 
{

	public static void main(String[] args) 
	
	{
	   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	   	
	   	Response res=RestAssured.given().delete("/delete/28");
	
	   	System.out.println(res.getStatusLine());
	   	System.out.println(res.getHeader("Content-Type"));
	   	System.out.println(res.getBody().asString());
	}

}
