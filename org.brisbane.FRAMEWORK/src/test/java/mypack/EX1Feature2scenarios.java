package mypack;

import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EX1Feature2scenarios 
{
	public RequestSpecification req;
	public Response res;
	public Scenario s;
	@Before
	public void method(Scenario s)
	{
		this.s=s;
	}
	
	@Given("^register EndPoint like \"(.*)\"$")
	public void register_EndPoint_like(String x) 
	{
		RestAssured.baseURI=x;
	}
	
	@And("define HTTP request")
	public void define_HTTP_request() 
	{
		req=RestAssured.given();
	}
	
	@When("submit requst via get method to Restful Service")
	public void submit_requst_via_get_method_to_Restful_Service() 
	{
		res=req.request(Method.GET,"/employees");
	}
	//"Then Status code is "200" and content Type is "application/json"

	@Then("^Then Status code is \"(.*)\" and content Type is \"(.*)\"$")
	public void method4(String scode,String ctype)
	{
		
	}
	
}
