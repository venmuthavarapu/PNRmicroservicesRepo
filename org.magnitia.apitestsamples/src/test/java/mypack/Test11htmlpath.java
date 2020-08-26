package mypack;
import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test11htmlpath 
{

	public static void main(String[] args) {
		// Create HTTP request
		   	RestAssured.baseURI="https://www.lipsum.com";
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.request(Method.GET,"Delhi");
		    //System.out.println(req);
		   	
		   	
		   	XmlPath xp=res.htmlPath();
		    String n=xp.getString("html.@lang");
		    System.out.println(n);
		    		    
		    
		    String y=xp.getString("html.head.title");
		    System.out.println(y);
		    			    
		   
}

}
