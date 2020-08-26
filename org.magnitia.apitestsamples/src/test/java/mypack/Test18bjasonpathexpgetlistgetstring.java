package mypack;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test18bjasonpathexpgetlistgetstring 
{

	public static void main(String[] args) 
	
	{
		// Create HTTP request
		   	RestAssured.baseURI="https://restcountries.eu/rest/v2/name";
		   	RequestSpecification req=RestAssured.given();
		   	
		   	Response res=req.queryParam("fullText","true").get("/india");
		    System.out.println("Response body Is:\n"+res.getBody().asString());

		
		   	JsonPath jp=res.jsonPath();
		   	//Getting single value of a field
	        String c=jp.getString("capital");
	        System.out.println(c);
		   
		    List<String>  b1=jp.getList("borders");
		    System.out.println(b1);
		  		    
		    
		    String cn=jp.getString("curriencies.name");	
		    System.out.println(cn);		    
		   
		    //Get sub field value of all given Parent Fields
		    List<String>  nl1=jp.getList("languages.name");		    //Get sub fields values of given Parent Fields
		    System.out.println(nl1);
		    
		  
}

}
