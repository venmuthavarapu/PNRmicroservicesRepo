package mypack;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test9xmlpath 
{

	public static void main(String[] args) {
		// Create HTTP request
		   	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weatherxml/city";
		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method 
		   	Response res=req.request(Method.GET,"Delhi");
		   	
		   	String hv=res.getHeader("content-Type");
		   	System.out.println(res.getBody().asString());
		   	if(hv.contains("xml"))
		   	{
		   		XmlPath xp=res.xmlPath();
		   		//Get node of <Temperature> under <weather> node
		   		System.out.println((String)xp.get("Weather.Temperature"));
		   		// via xmlpath
		 	}
		    
		   
}

}
