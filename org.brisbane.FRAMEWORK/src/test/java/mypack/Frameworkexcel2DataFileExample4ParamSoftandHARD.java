package mypack;


import org.json.JSONObject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Frameworkexcel2DataFileExample4ParamSoftandHARD
{
	@Test
	@Parameters({"userid","id","title","body","criteria"})
	public void method2(String uid,String pid,String t,String pbody,String c) throws Exception
		{
		 RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		 RequestSpecification req=RestAssured.given();
		 JSONObject jo=new JSONObject();
		 jo.put("userId",uid);
		 jo.put("id",pid);
		 jo.put("title",t);
		 jo.put("body",pbody);
		 req.header("Content-Type","application/json");
		 req.body(jo.toString());
		 Response res=req.request(Method.POST,"/Posts");
		 int sc=res.getStatusCode();
		 if(c.equalsIgnoreCase("unique") && sc==201)
		{
			 Reporter.log("Post Created....Properly");
			 Assert.assertTrue(true);
			 System.out.println("Creation of"+sc);
		 }
		 else if(c.equalsIgnoreCase("duplicate") && sc==200)
		 {
			 Reporter.log("Post created...workingProperly");
			 Assert.assertTrue(false);
			 System.out.println("Duplicate of"+sc);

		 }
		 else 
		 {
			 Reporter.log("Post creation...not workingProperly");
			 Assert.assertTrue(false);
			 System.out.println("Duplicate of"+sc);

		 }
			 
		 }
}

