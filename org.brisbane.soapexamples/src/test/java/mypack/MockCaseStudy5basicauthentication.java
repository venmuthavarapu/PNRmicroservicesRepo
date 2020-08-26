package mypack;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;

public class MockCaseStudy5basicauthentication {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/authperson";
	   	PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
	   	
	   	auth.setUserName("Kalam@example1.com");
	   	auth.setPassword("apibatch2fighters2");
	   	RestAssured.authentication=auth;
	   	
	   	Response res=RestAssured.given().get();	
		String mockres=res.getBody().jsonPath().get("sessionid");
	   	System.out.println("Session Id is :"+mockres);
	}

}
