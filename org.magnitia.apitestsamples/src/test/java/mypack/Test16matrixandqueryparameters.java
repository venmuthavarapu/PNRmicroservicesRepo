package mypack;


import java.io.IOException;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test16matrixandqueryparameters 
{

	public static void main(String[] args) throws IOException 
	{
		// Create HTTP request
	   		RestAssured.urlEncodingEnabled=false;
	   	   	RestAssured.baseURI="https://petstore.swagger.io/v2/pet/findByStatus;matrixparm=test";
		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method and Parameter Value
		// https://www.amazon.com/s?k=corona+beer&ref=nb_sb_noss_2
		   	Response res=
		   			 req.queryParam("offset","0").queryParam("pageSize","10").get("");

		//	Response res=req.queryParam("k","corona beer").queryParam("ref","nb_sb_ss_i_3_6").get("");
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


