package mypack;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test22bjasonpathexpconditionexample 
{

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) 
	
	{
		// Create HTTP request
		   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.request(Method.GET,"");
		    //System.out.println(req);
		
		   	JsonPath jp=res.jsonPath();
		    List<Map<String,String>>  ml=jp.getList("data");
		    
		   	for(int i=0;i<ml.size();i++) ///On list of entries in the current map
		   	{	
			   	for(Map.Entry e:ml.get(i).entrySet())	
			   		{
					    System.out.println(e.getKey()+":"+ e.getValue());
					   // System.out.println();
			   		}
			    System.out.println();
		   	}

		}
}

