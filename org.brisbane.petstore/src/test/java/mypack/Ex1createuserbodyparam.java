package mypack;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Ex1createuserbodyparam {

	public static void main(String[] args) 
	
	{
		   RestAssured.baseURI="http://petstore.swagger.io/v2";
		   RequestSpecification req=RestAssured.given();
		   req.contentType("application/json");
		   
		   JSONObject rp=new JSONObject();

		   rp.put("id", 11);
		   rp.put("username","nidvith");
		   rp.put("firstName", "love");
		   rp.put("lastName", "Stevev jobs");
		   rp.put("email", "dsad@gmail.com");
		   rp.put("password", "desertrose");
		   rp.put("phone", "0430388847");
		   rp.put("userStatus","0");
		   
		   req.body(rp.toString());
		   
		   Response res=req.post("/user");
		  	
		   	System.out.println(res.getStatusLine());
		   	System.out.println(res.getHeader("Content-Type"));
		   	System.out.println(res.getBody().asString());

	}

}
