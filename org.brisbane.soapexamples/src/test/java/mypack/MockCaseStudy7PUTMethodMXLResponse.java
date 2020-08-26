package mypack;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MockCaseStudy7PUTMethodMXLResponse {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/webservicesserver/numberconversion";
	   	Response res=RestAssured.given().post();
	   		   
	   	int sc=res.getStatusCode();
	  	System.out.println("The Status code received is : "+sc);
	  	
	  	String st=res.body().asString();
		System.out.println("Response body is : "+st);
		
		String x=res.body().xmlPath().getString("**.find{it.name()=='NumberToDollarsResult'}");
		System.out.println(x);
	}
	}


