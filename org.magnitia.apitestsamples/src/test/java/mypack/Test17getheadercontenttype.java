package mypack;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Test17getheadercontenttype 
{

	public static void main(String[] args) {
		// Create HTTP request
		   	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method 
		   	Response res=req.request(Method.GET,"Delhi");
		// Analyze Response in VArious representations
		   			//Status line
		   	//System.out.println(res.getBody().asString());
		   	String hv=res.getHeader("content-Type");
		   	if(hv.contains("json"))
		   	{
		   	JsonPath jp=res.jsonPath();
		   	String t=jp.get("Temperature");
			//String t=(String)jp.get("Temperature");
		   	//System.out.println(jp);
		 	System.out.println(t);
		 	}
		    
		   
}

}
