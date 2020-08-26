package mypack;




import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Xmlpathexamples 
{

	public static void main(String[] args)
	{
	
		{
	RestAssured.baseURI="http://ergast.com/api/f1";
	RequestSpecification req=RestAssured.given();
	Response res=req.request(Method.GET,"/2011");
	XmlPath xp=res.xmlPath();
	//Example1:
	int c1=xp.get("**.findAll{it.name()=='Race'}.size()");
 	System.out.println(c1);
 	
	//Example2:
	int c2=xp.get("**.findAll{it.@season=='2011'}.size()");
 	System.out.println(c2);
 	
 	

		}

	}
}
