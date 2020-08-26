package mypack;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Test26xlshssfworkbookex2ddtest20 {

	public static void main(String[] args) throws Exception 
	{
	    File f=new File("HSSFWorkbook.xls");
	    FileOutputStream fo=new FileOutputStream(f);
	    HSSFWorkbook wb=new HSSFWorkbook();
	    Sheet sh=wb.createSheet("Sheet1");
	    Row r=sh.createRow(0);
	    Cell c=r.createCell(0);
	    c.setCellValue("My Name is sAM");
	    sh.autoSizeColumn(0);
	    
	   //save file
	    wb.write(fo);//Saved In hard Disk
	    wb.close();
	    fo.close();
	}

}
