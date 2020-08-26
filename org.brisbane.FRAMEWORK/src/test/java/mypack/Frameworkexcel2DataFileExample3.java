package mypack;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.json.JSONObject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Frameworkexcel2DataFileExample3
{
	@DataProvider(name="mydata")
	public Object[][] method1() throws Exception
	{
		File f=new File("m1.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheetAt(0);
		
		int nour=sh.getPhysicalNumberOfRows();
		Row r=sh.getRow(1);
		
		int nouc=r.getLastCellNum();
		Object data[][]=new Object[nour-1][nouc];
		
		for(int i=1;i<nour;i++)
		{
			Row row=sh.getRow(i);
			for(int j=0;j<nouc;j++)
			{
				DataFormatter ft=new DataFormatter();
				data[i-1][j]=ft.formatCellValue(row.getCell(j));
			}
		}
		fi.close();
		wb.close();
		return(data);
		
	}
		
	

	@Test(dataProvider="mydata")
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
		 }
		 else if(c.equalsIgnoreCase("duplicate") && sc==200)
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
