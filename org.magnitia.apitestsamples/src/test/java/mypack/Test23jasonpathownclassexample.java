package mypack;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test23jasonpathownclassexample 
{

	public static void main(String[] args) 
	
	{
		// Create HTTP request
		   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.request(Method.GET,"");
		
		   	JsonPath jp=res.jsonPath();
	        //Employee[] el=jp.getObject("data",Employee[].class);
	       List<Employee> el=jp.getList("data",Employee.class);

	        
	        int i=1;
		   	for(Employee e:el) // 
		   	{
		    //System.out.println("Employee:"+i);
		    System.out.println("Employee id:"+e.id);
		    System.out.println("Employee name:"+e.employee_name);
		    System.out.println("Employee salary:"+e.employee_salary);
		    System.out.println("Employee age:"+e.employee_age);
		    System.out.println("Employee profile:\n"+e.profile_image);
		    i=i+1;
		   	}
		 
}

}
