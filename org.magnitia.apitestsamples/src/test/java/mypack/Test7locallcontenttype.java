package mypack;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test7locallcontenttype 
{

	public static void main(String[] args) {
		// Create HTTP request
		   //	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weatherxml/city";
		   	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method and Parameter Value
		   	Response res=req.request(Method.GET,"/pune");
		// Validate representation  of response body
		   			//Status line
		   	String hv=res.getHeader("Content-Type");
		   	
		   	if(hv.contains("json"))
		   	{
		   		System.out.println("response body is is json");
		   		String rb=res.asString();
			 	System.out.println("Response Body is :\n"+rb);
		   	}
		   	
		   	else if(hv.contains("xml"))
		   	{
		   		System.out.println("response body is in xml");
		   		String rb=res.asString();
			 	System.out.println("Response Body is :\n"+rb);
		   	}
			
		 	else if(hv.contains("html"))
		   	{
		   		System.out.println("response body is in html");
		   		String rb=res.asString();
			 	System.out.println("Response Body is :\n"+rb);
		   	}
			
		 	else if(hv.contains("csv"))
		   	{
		   		System.out.println("response body is in csv");
		   		String rb=res.asString();
			 	System.out.println("Response Body is :\n"+rb);
		   	}
			
		 	else 
		   	{
		   		System.out.println("response body is in plain text");
		   		String rb=res.asString();
			 	System.out.println("Response Body is :\n"+rb);
		   	}
			
		   	
		   	}
}
