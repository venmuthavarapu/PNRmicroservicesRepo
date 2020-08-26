package mypack;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Integration2restsergetholidaysforyear {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	
	   	RestAssured.baseURI="http://date.nager.at/Api/v2/PublicHolidays";
	   	RequestSpecification req=RestAssured.given();
	   	
	   	Response res=req.request(Method.GET,"2022/us/");	
	   	JsonPath jp=res.jsonPath();
	   	
	    List<String> restres=jp.getList("date");
		for(int i=0;i<restres.size();i++)
		{
			System.out.println(restres.get(i));
		}

	}

}
