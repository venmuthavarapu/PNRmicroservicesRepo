package mypack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test12queryparameters 
{

	public static void main(String[] args) throws IOException 
	{
		// Create HTTP request
		   	RestAssured.baseURI="https://www.amazon.com/s";
		   	RequestSpecification req=RestAssured.given();

		//Send Request with required Http method and Parameter Value
		   	// https://www.amazon.com/s?k=corona+beer&ref=nb_sb_noss_2
		   	Response res=
		   			 req.queryParam("k","corona beer").queryParam("ref","nb_sb_noss_2").get("");

		   //	Response res=req.queryParam("k","corona beer").queryParam("ref","nb_sb_ss_i_3_6").get("");
		// Analyze Response in VArious representations
		   			//Status line
		   	String rs1=res.getStatusLine();
		   	System.out.println(rs1);
		
		   	List<Header> hs=res.getHeaders().asList();
		   	for(Header h:hs)
		 	{
		 	System.out.println(h.getName()+":"+h.getValue());
		 	}
		 
		 
		 	String rb=res.getBody().asString();
		 
		 	//File f=new File("C:\\Magnitia\\amazon.txt");
		 	FileWriter fw=new FileWriter("C:\\Magnitia\\amazon.txt");
		 	fw.write(rb);
		 	fw.close();

	}
}


