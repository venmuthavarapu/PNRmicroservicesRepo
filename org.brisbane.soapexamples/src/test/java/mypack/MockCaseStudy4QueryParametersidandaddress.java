package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MockCaseStudy4QueryParametersidandaddress {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/person";
	   	   	
		Response res=RestAssured.given().queryParam("id","46").queryParam("search_item","address").get();
	    String restres=res.getBody().asString();	
	   	System.out.println(restres);
	   	String x=res.getBody().jsonPath().get("address.State");
	   	System.out.println(x);
	}

}
