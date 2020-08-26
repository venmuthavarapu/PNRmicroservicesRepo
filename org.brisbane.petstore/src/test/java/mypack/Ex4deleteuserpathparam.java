package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Ex4deleteuserpathparam {

	public static void main(String[] args) 
	
	{
		   RestAssured.baseURI="http://petstore.swagger.io/v2/user";
		   RequestSpecification req=RestAssured.given();
		  
		   Response response=req.delete("nidvith");
		   
		   int statuscode=response.getStatusCode();
		   
		   System.out.println(statuscode);

		   System.out.println(response.getHeader("Content-Type"));
		   System.out.println(response.getBody().asString());

	}

}
