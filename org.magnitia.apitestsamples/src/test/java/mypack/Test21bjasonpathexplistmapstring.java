package mypack;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test21bjasonpathexplistmapstring 
{

	public static void main(String[] args) 
	
	{
		// Create HTTP request
		   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.request(Method.GET,"");
		    //System.out.println(req);
		
		   	JsonPath jp=res.jsonPath();
		    List<Map<String,String>>  ml=jp.getList("data");
		    
		   	for(int i=0;i<ml.size();i++)
		   	{
		   		if(Integer.parseInt(ml.get(i).get("employee_salary"))<=100000 
		   			&& ml.get(i).get("employee_name").startsWith("A"))
		   			{
		   			System.out.println(ml.get(i).get("id"));
		   			System.out.println(ml.get(i).get("employee_name"));
		    		}
		   	}
		 
	}

}
