package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test32basicauth1ex7test25 
{
	public static void main(String[] args) throws Exception  
	{
			File f=new File("authbook.xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fi);
			Sheet sh=wb.getSheet("Sheet1");
			
			int nour=sh.getPhysicalNumberOfRows();
			int nouc=sh.getRow(0).getLastCellNum();
			// Create result heading next to last column date and time
			Date dt=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMMyyyy-hh-mm-ss");
			
			String cname1="Status code on" +sf.format(dt);
			sh.getRow(0).createCell(nouc).setCellValue(cname1);
			
			String cname2="Content type response on" +sf.format(dt);
			sh.getRow(0).createCell(nouc+1).setCellValue(cname2);
			
			String cname3="Response body on" +sf.format(dt);
			sh.getRow(0).createCell(nouc+2).setCellValue(cname3);
			
			//Data Driven from 2nd row(index=1) in excel sheet
				for(int i=1;i<nour;i++)
			 	{
					DataFormatter df=new DataFormatter();
					String uid=df.formatCellValue(sh.getRow(i).getCell(0));
					String pwd=df.formatCellValue(sh.getRow(i).getCell(1));
												
			 	// Create HTTP request
				RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
				RequestSpecification req=RestAssured.given().auth().preemptive().basic(uid,pwd);
				
				Response res=req.request(Method.GET,"");
			    //JsonPath jp=res.jsonPath();
				int sc=res.getStatusCode();		
				sh.getRow(i).createCell(nouc).setCellValue(sc);
				sh.getRow(i).createCell(nouc+1).setCellValue(res.getHeader("Content-Type"));
				sh.getRow(i).createCell(nouc+2).setCellValue(res.getBody().asString());
			
			 	}
				sh.autoSizeColumn(nouc);
				sh.autoSizeColumn(nouc+1);
				sh.autoSizeColumn(nouc+2);

				FileOutputStream fo=new FileOutputStream(f);
				wb.write(fo);//Saved In hard Disk
			    wb.close();
			    fi.close();		
			    fo.close();	
}
}

