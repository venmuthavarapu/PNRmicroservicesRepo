package mypack;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Casestudyex1get1 
{

	public static void main(String[] args) 
	
	{
	   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	   	RequestSpecification req=RestAssured.given();

	   	Response res=req.request(Method.GET,"/employees");
	
	   	String rs1=res.getStatusLine();
	   	System.out.println(rs1);
	   	
	 	System.out.println(res.getHeader("Content-Type"));
	   	
	    String rb=res.getBody().asString();
	 	System.out.println("Response Body is :\n"+rb);


	}

}
