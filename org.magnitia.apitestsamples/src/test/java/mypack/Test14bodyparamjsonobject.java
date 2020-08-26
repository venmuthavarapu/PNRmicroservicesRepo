package mypack;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test14bodyparamjsonobject 
{

	public static void main(String[] args) 
	{
		// Create HTTP request
		   	RestAssured.baseURI="http://restapi.demoqa.com/customer//register";
		   	RequestSpecification req=RestAssured.given();

		 	
		 	JSONObject jo=new JSONObject();
		 	
		 	jo.put("FirstName","Ram");
			jo.put("LastName","Muthavarapu");
			jo.put("UserName","Ram");
			jo.put("PassWord","magnitia");
			jo.put("Email","muthavarapuccg1@gmail.com");
			
			req.body(jo.toString());
		 	Response res=req.request(Method.POST,"");
		 	//Response res=req.request(Method.POST,"");
		 	int sc=res.getStatusCode();
		 	System.out.println("The Status code received: "+sc);
		 	System.out.println("The response Body: "+res.body().asString());
		 	
	}
}


