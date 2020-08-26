package mypack;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DatabasetestingMOCKREALANDCOMPAREDB {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		String path="cmd /c start C:\\apibatch2\\mymocks\\wiremock.bat";
	    Runtime.getRuntime().exec(path);
		
	   	RestAssured.baseURI="http://localhost:9999/person";
	    String mockres=RestAssured.given().get("/p0001").getBody().asString();	
	   	System.out.println(mockres);
	
	   	RestAssured.baseURI="http://date.nager.at/Api/v2/PublicHolidays";
	   	List<String> restres=RestAssured.given().get(mockres).jsonPath().getList("date");
	   //	RequestSpecification req=RestAssured.given();
	 	System.out.println("No: Of Holidays are "+restres.size());
	 	for(int i=0;i<restres.size();i++)
	 	{
		 	System.out.println(restres.get(i));

	 	}
	 	
	 	Class.forName("com.mysql.jdbc.Driver");
	 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root");
	 	Statement st=con.createStatement();
	 	String data[]=mockres.split("/");
	 	int y=Integer.parseInt(data[0]);
	 	ResultSet res=st.executeQuery("select * from holidays where year="+y+" and cc like '"+data[1]+"%';");
	 	List<String> dbres=new ArrayList<String>();
 		//System.out.println("No of rows from the Database is :"+dbres.size());

	 	while(res.next())
		 	{
		 		String z=res.getString(1);
		 		System.out.println(z);
		 		dbres.add(z);
		 		//System.out.println(" "+dbres.size()+" fetched record of DB is :"+z);


		 	}
	 	con.close();
	 	if(restres.equals(dbres))
		 	{
		 		System.out.println("component test pasees");
		 	}
	 	else
		 	{
		 		System.out.println("component test failed");
		 	}	
	 	Runtime.getRuntime().exec("TaskKill /F ?IM conhost.exe");
	}
}
	 	
	 	
	


