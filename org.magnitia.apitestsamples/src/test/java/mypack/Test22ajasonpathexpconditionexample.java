package mypack;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test22ajasonpathexpconditionexample 
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
		    
		   	for(int i=0;i<ml.size();i++) ///On lsit of Maps
		   	{
		    System.out.println("Employee:"+(i+1));
		    //Map<String,String>  m=jp.getMap("data["+i+"]");
		    System.out.println(ml.get(i).get("id"));
		    System.out.println(ml.get(i).get("employee_name"));
		    System.out.println(ml.get(i).get("employee_salary"));
		    System.out.println(ml.get(i).get("employee_age"));
		    System.out.println(ml.get(i).get("profile_image"));
		   	}
		 
}

}
