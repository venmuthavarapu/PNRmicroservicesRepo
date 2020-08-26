package mypack;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import io.restassured.RestAssured;

public class Databasetesting2MOCKmongodbCOMPAREdb {

	
	public static void main(String[] args) throws Exception 
	{
		
	   	RestAssured.baseURI="http://localhost:9999/person";
	    String yearres=RestAssured.given().get("/year").getBody().asString();	
	   	System.out.println(yearres);
	   	
	   	RestAssured.baseURI="http://localhost:9999/person";
	    String countryres=RestAssured.given().get("/canada").getBody().asString();	
	   	System.out.println(countryres);
	   	String yrcou=yearres+"/"+countryres;
	   	   		      	
	   	RestAssured.baseURI="http://date.nager.at/Api/v2/PublicHolidays";
	   	List<String> restres=RestAssured.given().get(yrcou).jsonPath().getList("date");
	 	System.out.println("No: Of Holidays are "+restres.size());
	   	System.out.println(restres);
	   	
	   	//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
		@SuppressWarnings("resource")
		MongoClient mongoclient=new MongoClient("localhost",27017);
	   	MongoDatabase db=mongoclient.getDatabase("rammangodb");
	   	MongoCollection<Document> col=db.getCollection("holidays");
		//System.out.println(col);

	   	Document doc=col.find(Filters.and(Filters.eq("year",yearres),Filters.regex("cc",countryres))).first();
	   	
	   	//System.out.println(doc.toJson());
	
		List<String> dbres=(ArrayList<String>) doc.get("date");
		System.out.println(dbres);
		
	 	if(restres.equals(dbres))
		 	{
		 		System.out.println("component test pasees");
		 	}
	 	else
		 	{
		 		System.out.println("component test failed");
		 	}	
	}
}
	 	
	 	
	


