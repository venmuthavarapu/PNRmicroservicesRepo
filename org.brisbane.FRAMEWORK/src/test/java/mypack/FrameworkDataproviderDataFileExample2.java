package mypack;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FrameworkDataproviderDataFileExample2
{
	@DataProvider(name="mydata")
	public Object[][] method1()
	{
	 Object[][] data=new Object[][]
	{
		 {22,45,"post1","hi","unique"},
			 {23,56,"post2","hi r u","unique"},
			 	{33,45,"post3","44 duplicate entry","duplicate"},
			 		{44,56,"post3","55 duplicate entry","duplicate"}
	 };
	 return(data);
	 }

	@Test(dataProvider="mydata")
	public void method2(int uid,int pid,String t,String pbody,String c ) throws Exception
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
		 }
		 else if(c.equalsIgnoreCase("duplicate") && sc==201)
		 {
			 Reporter.log("Post created...workingProperly");
			 Assert.assertTrue(false);
		 }
		 else 
		 {
			 Reporter.log("Post creation...not workingProperly");
			 Assert.assertTrue(false);
		 }
			 
		 }

}