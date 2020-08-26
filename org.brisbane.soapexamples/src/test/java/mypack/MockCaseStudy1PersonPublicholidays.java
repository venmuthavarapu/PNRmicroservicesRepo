package mypack;
import java.util.List;

import io.restassured.RestAssured;

public class MockCaseStudy1PersonPublicholidays {

	public static void main(String[] args) throws Exception
	{

	   	RestAssured.baseURI="http://localhost:9999/person";
	    String mockres=RestAssured.given().get("/p0001").getBody().asString();	
	   	System.out.println(mockres);
	   	
	   	RestAssured.baseURI="https://date.nager.at/Api/v2/PublicHolidays";
	    List<String> restres=RestAssured.given().get(mockres).jsonPath().getList("date");
	    for(int i=0;i<restres.size();i++)
	    
	    {
	   	System.out.println(restres.get(i));
	    }
	}

}
