package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Ex3getuserqueryandpathparamc {

	public static void main(String[] args) 
	
	{
		   RestAssured.baseURI="http://petstore.swagger.io/v2";
		   RequestSpecification req=RestAssured.given();
		  
		   Response response=req.queryParam("username","mrmuthavarapu").queryParam("password","desertrose").get("/user/login");

		   
		   req.contentType("application/json");
		   
		   //JSONObject rp=new JSONObject();

		   /*rp.put("id", 11);
		   rp.put("username","muthavarapu");
		   rp.put("firstName", "love");
		   rp.put("lastName", "Stevev jobs");
		   rp.put("email", "dsad@gmail.com");
		   rp.put("password", "desertrose");
		   rp.put("phone", "0430388847");
		   rp.put("userStatus","0");
		   
		   req.body(rp.toString());*/
		   
		  	
		   	//System.out.println(response.getStatusLine());
		   	System.out.println(response.getStatusCode());

		   	System.out.println(response.getHeader("Content-Type"));
		   	System.out.println(response.getBody().asString());

	}

}
