package mypack;
import java.io.File;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test18ajasonpathexpgetlistgetstring 
{

	public static void main(String[] args) 
	
	{
		// Create HTTP request
		   	RestAssured.baseURI="https://restcountries.eu/rest/v2/all";
		   	RequestSpecification req=RestAssured.given();
		   	Response res=req.queryParam("field","name;capital;currencies").get();
		
		   	JsonPath jp=res.jsonPath();
		    List<String>  l1=jp.getList("name");	
		    List<String>  l2=jp.getList("capital");	
		    List<String>  l3=jp.getList("curriencies.name");	
		    File f=new File("countryoutput.txt");
		   // FileWriter fw=new FileWriter(f);
		   // BufferedWriter bw=new BufferedWriter(fw);
		   // for(int i=0; i<l1.size();i++)
		 	{
		 	//bw.write(l1.get(i)+":"+l2.get(i)+":"+l3.get(i).getList(1));
		 	//bw.newLine();
		 	}

		 	//bw.close();
		 	//fw.close();
    
		   
}

}
