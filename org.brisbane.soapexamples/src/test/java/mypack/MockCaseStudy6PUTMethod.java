package mypack;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MockCaseStudy6PUTMethod {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/myform1";
	   	RequestSpecification req=RestAssured.given();
	   	
	   	JSONObject jo=new JSONObject();
	   	jo.put("empno", "12");
	   	jo.put("company", "magnitia");
	   	req.body(jo.toString());
	   	
	   	Response res=req.request(Method.POST,"");
	   	int sc=res.getStatusCode();
	  	System.out.println("The Status code received is : "+sc);
	  	
	  	String st=res.body().asString();
		System.out.println("Response body is : "+st);
	}
	}


