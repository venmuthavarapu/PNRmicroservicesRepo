package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mypack.EnricoStub.DateType;
import mypack.EnricoStub.GetHolidaysForYear;
import mypack.EnricoStub.GetHolidaysForYearResponse;
import mypack.EnricoStub.HolidayCollectionType;
import mypack.EnricoStub.HolidayType;


public class IntegrationTest1and2comparision {

	public static void main(String[] args) throws Exception
	
	{
		File f=new File("integrationddt.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		    
	    int nour=sh.getPhysicalNumberOfRows();
	    int nouc=sh.getRow(0).getLastCellNum();
	    
	    SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
		Date d=new Date();
		
		CellStyle style=wb.createCellStyle();
		style.setWrapText(true);
		
		Cell rc=sh.getRow(0).createCell(nouc);
		rc.setCellValue("Integration Test results on"+sf.format(d));
		rc.setCellStyle(style);
				
		for(int i=1;i<nour;i++)
		{
			Thread.sleep(5000);
			DataFormatter df=new DataFormatter();
			String y=df.formatCellValue(sh.getRow(i).getCell(0));
			String scc=df.formatCellValue(sh.getRow(i).getCell(1));
			String sr=df.formatCellValue(sh.getRow(i).getCell(2));
			String ht=df.formatCellValue(sh.getRow(i).getCell(3));
			String rcc=df.formatCellValue(sh.getRow(i).getCell(4));

			// Creating Object Stub Class
				EnricoStub stub=new EnricoStub();
			//	
				GetHolidaysForYear req1=new GetHolidaysForYear();
				Integer iy=Integer.parseInt(y);
				BigInteger by=BigInteger.valueOf(iy);
				
				System.out.println(iy);
		//
				req1.setYear(by);
				req1.setCountry(scc);
				req1.setRegion(sr);
				req1.setHolidayType(ht);
				ArrayList<String> soapres=new ArrayList<String>();
			//Create response object by submitting parameterized request
				try
				{
					GetHolidaysForYearResponse res1=stub.getHolidaysForYear(req1);
					HolidayCollectionType l=res1.getHolidays();
					HolidayType x[]=l.getHoliday();
		
					for(int j=0;j<x.length;j++)
						{
				DateType dt=x[j].getDate();
				//System.out.println(dt.getDay()+"-"+dt.getMonth()+":"+x[i].getHolidayType());
				
				if(dt.getMonth()<10 && dt.getDay()<10)
				{ 
					soapres.add(dt.getYear()+"-0"+dt.getMonth()+"-0"+dt.getDay());
				}
				else if(dt.getMonth()<10 && dt.getDay()>10)
				{
					soapres.add(dt.getYear()+"-0"+dt.getMonth()+"-"+dt.getDay());
				}
				else if(dt.getMonth()>=10 && dt.getDay()<10)
				{
					soapres.add(dt.getYear()+"-"+dt.getMonth()+"-0"+dt.getDay());
				}
				else 
				{
					soapres.add(dt.getYear()+"-"+dt.getMonth()+"-"+dt.getDay());
				}
				//System.out.println(soapres.get(i));
				
			
			}
			}
	catch(Exception ex)
			{
						System.out.println("No holiday for the given year");
		
			}
		
		   	RestAssured.baseURI="http://date.nager.at/Api/v2/PublicHolidays";
		   	RequestSpecification req2=RestAssured.given();
		   	
		   	Response res2=req2.request(Method.GET,y+"/"+rcc);	
		   	JsonPath jp=res2.jsonPath();
		   	
		    List<String> restres=jp.getList("date");
			if(restres.equals(soapres))
			{
				sh.getRow(i).createCell(nouc).setCellValue("Integration Test passed");
				//sh.getRow(i).createCell(nouc).setCellStyle(style);
				
				
			}
			else
			{
				sh.getRow(i).createCell(nouc).setCellValue("Integration Test failed");
				//sh.getRow(i).createCell(nouc).setCellStyle(style);
			}
		}
		sh.autoSizeColumn(nouc);
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		fo.close();
		fi.close();
		wb.close();
		
	}
}
	
	

	
 

