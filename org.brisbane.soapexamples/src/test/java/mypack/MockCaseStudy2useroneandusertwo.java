package mypack;

import io.restassured.RestAssured;

public class MockCaseStudy2useroneandusertwo {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/user/one";
	    String restres=RestAssured.given().get().getBody().asString();	
	   	System.out.println(restres);
	   	
	   	RestAssured.baseURI="http://localhost:9999/user/two";
	    String restres1=RestAssured.given().get().getBody().asString();	
	   	System.out.println(restres1);


	}

}
