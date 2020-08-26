package mypack;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test27xlsxssfworkbookcreationex3ddtest21 {

	public static void main(String[] args) throws Exception 
	{
	    
	    XSSFWorkbook wb=new XSSFWorkbook();
	    Sheet sh=wb.createSheet("Sheet1");
	    Row hr=sh.createRow(0);
	    hr.createCell(0).setCellValue("ID");
	    hr.createCell(1).setCellValue("NAME");
	    hr.createCell(2).setCellValue("AGE");
	    hr.createCell(3).setCellValue("SAL");
	    hr.createCell(4).setCellValue("PROFILE");
	    		// Create HTTP request
	  	   	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
	   	RequestSpecification req=RestAssured.given();
	   	Response res=req.request(Method.GET,"");	
	   	JsonPath jp=res.jsonPath();
	   	
	    List<Map<String,String>> m1=jp.getList("data");
	    int rownum=1;//2nd row-index1
	    for(int i=0;i<m1.size();i++)
	    {
	    	Row dr=sh.createRow(rownum);
	        dr.createCell(0).setCellValue(m1.get(i).get("id"));
		    dr.createCell(1).setCellValue(m1.get(i).get("employee_name"));
		    dr.createCell(2).setCellValue(m1.get(i).get("employee_age"));
		    dr.createCell(3).setCellValue(m1.get(i).get("employee_salary"));
		    dr.createCell(4).setCellValue(m1.get(i).get("profile_image"));
		    rownum++;
	    }
	    // Apply Autofit on 5 used columns
	    	
	    	for(int j=0;j<5;j++)
	    	{
	    		sh.autoSizeColumn(j);
	    	}
	 	 //save file
		File f=new File("samplexxx.xlsx");
		FileOutputStream fo=new FileOutputStream(f);
		
	    wb.write(fo);//Saved In hard Disk
	    wb.close();
	    fo.close();
	}

}


