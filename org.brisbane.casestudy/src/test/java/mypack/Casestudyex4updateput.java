package mypack;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Casestudyex4updateput 
{

	public static void main(String[] args) 
	
	{
	   RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	   RequestSpecification req=RestAssured.given();
	   
	   JSONObject rp=new JSONObject();

	   rp.put("name", "Stevev jobs");
	   rp.put("age", 71);
	   rp.put("salary", 735435);
	   
	   req.body(rp.toString());
	   
	   Response res=req.post("/update/28");
	   
	   	System.out.println(res.getStatusLine());
	   	System.out.println(res.getHeader("Content-Type"));
	   	System.out.println(res.getBody().asString());




	}

}
