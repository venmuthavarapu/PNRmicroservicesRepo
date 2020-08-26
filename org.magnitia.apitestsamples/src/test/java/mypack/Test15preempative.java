package mypack;

import java.util.List;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test15preempative 
{

	public static void main(String[] args) 
	{
		// Create HTTP request
		   	RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		   	PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		   	auth.setUserName("ToolsQA");
		   	auth.setPassword("TestPassword");
		   	RestAssured.authentication=auth;
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.request(Method.GET,"");


	
		   	String rs1=res.getStatusLine();
		   	System.out.println(rs1);
		   	
		   	Headers rhs=res.getHeaders();
		   	List<Header> hs=rhs.asList();
		   	for(Header h:hs)
		 	{
		 	System.out.println(h.getName()+":"+h.getValue());
		 	}
		    
		   	String rb=res.getBody().asString();
		 	System.out.println(rb);
		}
}


