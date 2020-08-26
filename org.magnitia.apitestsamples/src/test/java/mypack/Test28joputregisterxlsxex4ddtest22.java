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
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test28joputregisterxlsxex4ddtest22 
{
	public static void main(String[] args) throws Exception  
	{
			File f=new File("regbook.xlsx");
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
			
			String cname2="Content Type response on" +sf.format(dt);
			sh.getRow(0).createCell(nouc+1).setCellValue(cname2);
			
			String cname3="Response body on" +sf.format(dt);
			sh.getRow(0).createCell(nouc+2).setCellValue(cname3);
			
			
			//Data Driven from 2nd row(index=1) in excel sheet
				for(int i=1;i<nour;i++)
			 	{
					DataFormatter df=new DataFormatter();
					String x=df.formatCellValue(sh.getRow(i).getCell(0));
					String y=df.formatCellValue(sh.getRow(i).getCell(1));
					String z=df.formatCellValue(sh.getRow(i).getCell(2));
					String w=df.formatCellValue(sh.getRow(i).getCell(3));
					
			 	// Create HTTP request
				RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
				RequestSpecification req=RestAssured.given();

		 	
				JSONObject jo=new JSONObject();
		 	
				jo.put("userid",x);
				jo.put("id",y);
				jo.put("title",z);
				jo.put("body",w);
			
				req.body(jo.toString());
			 	Response res=req.request(Method.POST,"");
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

