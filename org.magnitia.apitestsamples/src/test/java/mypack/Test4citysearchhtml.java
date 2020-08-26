package mypack;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Test4citysearchhtml 
{

	public static void main(String[] args) {
		// Create HTTP request
		   	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weatherxml/city";
		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method and Parameter Value
		   	Response res=req.request(Method.GET,"/Brisbane");
		// Analyze Response in VArious representations
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
		   	@SuppressWarnings("rawtypes")
			ResponseBody rbobj=res.getBody();
		 	String rb=rbobj.asString();
		 	System.out.println("Response Body is :\n"+rb);
}

}

