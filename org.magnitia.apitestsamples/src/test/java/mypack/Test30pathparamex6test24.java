package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test30pathparamex6test24 
{
	public static void main(String[] args) throws Exception  
	{
			File f=new File("postbook.xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fi);
			Sheet sh=wb.getSheet("sheet1");
			
			int nour=sh.getPhysicalNumberOfRows();
			int nouc=sh.getRow(0).getLastCellNum();
			// Create result heading next to last column date and time
		
			sh.getRow(0).createCell(nouc).setCellValue("UserID");
			sh.getRow(0).createCell(nouc+1).setCellValue("Title");
			sh.getRow(0).createCell(nouc+2).setCellValue("Body");
			
			//Data Driven from 2nd row(index=1) in excel sheet
				for(int i=1;i<nour;i++)
			 	{
					DataFormatter df=new DataFormatter();
					String URI=df.formatCellValue(sh.getRow(i).getCell(0));
					String id=df.formatCellValue(sh.getRow(i).getCell(1));
					//String ft=df.formatCellValue(sh.getRow(i).getCell(2));
										
			 	// Create HTTP request
				RestAssured.baseURI=URI+"/"+id;
				RequestSpecification req=RestAssured.given();
				
				Response res=req.request(Method.GET,"");
				if(res.getStatusCode()==200)
				{
				JsonPath jp=res.jsonPath();
				
		 	    sh.getRow(i).createCell(nouc).setCellValue(jp.getString("userId"));
		 	    sh.getRow(i).createCell(nouc+1).setCellValue(jp.getString("title"));
		 	    sh.getRow(i).createCell(nouc+2).setCellValue(jp.getString("body"));
		 	    
	
			 	}
				else
				{
					System.out.println(res.getBody().asString());
				}
				}
				sh.autoSizeColumn(nouc);
				sh.autoSizeColumn(nouc+1);
				sh.autoSizeColumn(nouc+2);
				sh.autoSizeColumn(nouc+3);
				FileOutputStream fo=new FileOutputStream(f);
				wb.write(fo);//Saved In hard Disk
			    wb.close();
			    fi.close();		
			    fo.close();	
			 	}
	}


