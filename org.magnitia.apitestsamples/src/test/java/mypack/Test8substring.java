package mypack;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test8substring 
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
		   	String x=res.getStatusLine();
		   	System.out.println(x);
		   	System.out.println("");
		   	
		   	
		   	String ver=x.substring(0,8);
		   	String scode=x.substring(9,12);
		   	String status=x.substring(13);
		   	
		   	System.out.println("Http version Is: "+ver);
			System.out.println("Http Status Code Is: "+scode);
			System.out.println("Http Status Is: "+status);
		   	
		   	
		   	}
}

