package mypack;

import java.io.File;

//import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



//XSSFWorkbook->createsheet->Create Row>
//Create cell in row>Selvalue in cell
//Auto Size


public class Test25xlsxxssfworkbookex1ddtest19 {

	public static void main(String[] args) throws Exception 
	{
	    // Create .xlsx file in RAM
	    XSSFWorkbook wb=new XSSFWorkbook();
	    Sheet sh=wb.createSheet("Sheet1");
	    Row r=sh.createRow(0);
	    Cell c=r.createCell(0);
	    c.setCellValue("My Name is Ram");
	    sh.autoSizeColumn(0);
	    
	   //save file .xlsx file in HDD
	    File f=new File("Test25xlsxxssfworkbookex1dd.xlsx");
	    FileOutputStream fo=new FileOutputStream(f);
	   
	    //Saved In hard Disk
	    wb.write(fo);//Saved In hard Disk
	    wb.close();
	    fo.close();
	}

}

