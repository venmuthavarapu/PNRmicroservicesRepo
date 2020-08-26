package mypack;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test6multipleparamgooglesearch 
	{

	public static void main(String[] args) {
		// Create HTTP request
		   	RestAssured.baseURI="https://www.google.com";
		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method with more than one Parameter Value
		   	//Response res=req.request(Method.GET,"/Brisbane");
		   	Response res=req.queryParam("q","Magnitia kodapur").get("/search");
		// Analyze Response in VArious representations
		   			//Status line
		   	String rs1=res.getStatusLine();
		   	System.out.println("Status Line is as follows\n"+rs1);
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
		   //	ResponseBody rbobj=res.getBody();
		 	String rb=res.getBody().asString();
		 	System.out.println(rb);
		}

}

