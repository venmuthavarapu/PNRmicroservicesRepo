package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MockCaseStudy3404errormsg {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/magnitia";
	   	Response res=RestAssured.given().get();
		System.out.println(res.getStatusCode());
	    String restres=res.getBody().asString();	
	   	System.out.println(restres);

	}

}
