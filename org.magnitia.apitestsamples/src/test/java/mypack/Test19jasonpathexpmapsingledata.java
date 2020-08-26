package mypack;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test19jasonpathexpmapsingledata 
{

	public static void main(String[] args) 
	
	{
		// Create HTTP request
		   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.request(Method.GET,"");
		    //System.out.println(req);
		
		   	JsonPath jp=res.jsonPath();
		 		    
		    //Get 1stEmployee Details
		    Map<String,String>  m=jp.getMap("data[1]");
		    
		    System.out.println(m.get("id"));
		    System.out.println(m.get("employee_name"));
		    System.out.println(m.get("employee_salary"));
		    System.out.println(m.get("employee_age"));
		    System.out.println(m.get("profile_image"));
		 
}

}
