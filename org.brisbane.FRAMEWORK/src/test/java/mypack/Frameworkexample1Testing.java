package mypack;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Frameworkexample1Testing
{
	public RequestSpecification req;
	public Response res;
	public JsonPath jp;
	public JSONObject jo;
	@BeforeMethod
	public void common() 
	{
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	req=RestAssured.given();
	}
	
	
	@Test(priority=1)
	public void getPosts()
	{
	 res=req.request(Method.GET,"/Posts");
	 int sc=res.getStatusCode();
	 String rb=res.getBody().asString();
	 if(sc==200 &&!rb.equals(""))
	 {
		 Reporter.log("Posted.....Properly");
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 Reporter.log("....Post not workingProperly");
		 Assert.assertTrue(false);
	 } 
		 
	 }
		
	@Test(priority=2)
	public void getSpecificPost()
		{
		 res=req.request(Method.GET,"/Posts/1");
		 int sc=res.getStatusCode();
		 jp=res.jsonPath();
		 int id=jp.get("id");
		 if(sc==200 && id==1)
		 {
			 Reporter.log("Post Resourse.working....Properly");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Reporter.log("Post Resourse....not workingProperly");
			 Assert.assertTrue(false);
		 } 
			 
		 }

	@Test(priority=3)
	public void createpost() throws Exception
		{
		 jo=new JSONObject();
		 jo.put("userId",10);
		 jo.put("id",101);
		 jo.put("title","magnitia");
		 jo.put("title","student r sleeping");
		 req.header("Content-Type","application/json");
		 req.body(jo.toString());
				 res=req.request(Method.POST,"/Posts");
		 int sc=res.getStatusCode();
		 if(sc==201)
		 {
			 Reporter.log("Post Created....Properly");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Reporter.log("Post not...workingProperly");
			 Assert.assertTrue(false);
		 } 
			 
		 }

	@Test(priority=4,dependsOnMethods= {"createpost"})
	public void updatepost() throws Exception
	{
	 jo=new JSONObject();
	 jo.put("userId",10);
	 jo.put("id",101);
	 jo.put("title","magnitia");
	 jo.put("body","body of message");
	 req.header("Content-Type","application/json");
	 req.body(jo.toString());
	
	 res=req.request(Method.PUT,"/Posts/1");
	 int sc=res.getStatusCode();
	 if(sc==200)
	 {
		 Reporter.log("Post Created....Properly");
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 Reporter.log("Post not...workingProperly");
		 Assert.assertTrue(false);
	 } 
		 
	 }

	@Test(priority=5,dependsOnMethods= {"createpost","updatepost"})
	public void deletepost() 
	{
	 res=req.request(Method.DELETE,"/Posts/101");
	 int sc=res.getStatusCode();
	 if(sc==200)
	 {
		 Reporter.log("Deletion.working....Properly");
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 Reporter.log("Deletion....not workingProperly");
		 Assert.assertTrue(false);
	 } 
		 
	 }

}



