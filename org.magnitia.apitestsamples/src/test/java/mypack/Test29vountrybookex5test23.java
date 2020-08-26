package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test29vountrybookex5test23 
{
	public static void main(String[] args) throws Exception  
	{
			File f=new File("countrycap.xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fi);
			Sheet sh=wb.getSheet("Sheet1");
			
			int nour=sh.getPhysicalNumberOfRows();
			int nouc=sh.getRow(0).getLastCellNum();
			// Create result heading next to last column date and time
			Date dt=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMMyyyy-hh-mm-ss");
			
			String cname1="Capital Results on" +sf.format(dt);
			sh.getRow(0).createCell(nouc).setCellValue(cname1);
			
			String cname2="Borders Results on" +sf.format(dt);
			sh.getRow(0).createCell(nouc+1).setCellValue(cname2);
			
			//Data Driven from 2nd row(index=1) in excel sheet
				for(int i=1;i<nour;i++)
			 	{
					DataFormatter df=new DataFormatter();
					String URI=df.formatCellValue(sh.getRow(i).getCell(0));
					String cn=df.formatCellValue(sh.getRow(i).getCell(1));
					String ft=df.formatCellValue(sh.getRow(i).getCell(2));
										
			 	// Create HTTP request
				RestAssured.baseURI=URI;
				RequestSpecification req=RestAssured.given();
				
				Response res=req.queryParam("fullText",ft).get("/"+cn);
				JsonPath jp=res.jsonPath();
				
		 	    String c=jp.getString("capital");
		 	    sh.getRow(i).createCell(nouc).setCellValue(c);
		 	    
		 	    List<String> l=jp.getList("borders");
		 	    sh.getRow(i).createCell(nouc+1).setCellValue(l.toString());
			
			 	}
				sh.autoSizeColumn(nouc);
				sh.autoSizeColumn(nouc+1);
				FileOutputStream fo=new FileOutputStream(f);
				wb.write(fo);//Saved In hard Disk
			    wb.close();
			    fi.close();		
			    fo.close();	
}
}

