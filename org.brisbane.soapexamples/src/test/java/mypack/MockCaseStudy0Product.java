package mypack;

import io.restassured.RestAssured;

public class MockCaseStudy0Product {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/product";
	    String restres=RestAssured.given().get("/p0001").getBody().asString();	
	   	System.out.println(restres);





	}

}
