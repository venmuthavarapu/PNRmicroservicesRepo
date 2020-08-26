package mypack;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
//import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
/*public class Pract 
{

	public static void main(String[] args) 
	{
		// Create HTTP request
	RestAssured.baseURI="https://restcountries.eu/rest/v2";
	RequestSpecification req=RestAssured.given();
		//Send Request with required Http method and Parameter Value
	Response res=req.request(Method.GET,"/Algeria");
		// Analyze HTTP Response in Various representations
		   			//Status line
		String sl=res.getStatusLine();
		System.out.println(sl);
		Headers rhs=res.getHeaders();
		List<Header> hs=rhs.asList();
	for (Header h:hs)
	{
	 	System.out.println(h.getName()+":"+h.getValue());	
	}
	String rbdy=res.getBody().asString();
	System.out.println("Response Body is "+rbdy);	


    }}

//https://restcountries.eu/rest/v2/all

*/


public class Pract 
{

	public static void main(String[] args) {
		// Create HTTP request
		   	RestAssured.baseURI="https://restapi.demoqa.com/utilities/weather/city";
		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method and Parameter Value
		   	Response res=req.request(Method.GET,"/Brisbane");
		// Analyze HTTP Response in Various representations
		   			//Status line
		   	
		   	
		   	String rs1=res.getStatusLine();
		   	System.out.println("Status Line is as follows\n"+rs1);
		   	System.out.println("\n");//Make up
		   			//Headers
		   	System.out.println("Headers for the response is:");
		   	Headers rhs=res.getHeaders();
		   	List<Header> hs=rhs.asList();  
		   	for(Header h:hs)
		 	{
		 	System.out.println(h.getName()+":"+h.getValue());
		 	}
		    System.out.println("");  //Make up
		    		// Response
		   	
		    ResponseBody<?> rbobj=res.getBody();
		    String rb=rbobj.asString();

		 	System.out.println("Response Body is :\n"+rb);
}

}

