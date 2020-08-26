package mypack;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test20jasonpathexpmapstring 
{

	public static void main(String[] args) 
	
	{
		// Create HTTP request
		   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.request(Method.GET,"");
		    //System.out.println(req);
		
		   	JsonPath jp=res.jsonPath();
		   	int noe=jp.getList("data").size();
		    System.out.println("No of of records in the system is:"+noe);

		 		    
		    //Get 1stEmployee Details
		   	for(int i=0;i<noe;i++)
		   	{
		    System.out.println("Employee:"+(i+1));
		    Map<String,String>  m=jp.getMap("data["+i+"]");
		    System.out.println(m.get("id"));
		    System.out.println(m.get("employee_name"));
		    System.out.println(m.get("employee_salary"));
		    System.out.println(m.get("employee_age"));
		    System.out.println(m.get("profile_image"));
		   	}
		 
}

}
