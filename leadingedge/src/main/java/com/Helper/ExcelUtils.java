package com.Helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	XSSFWorkbook wb;
	XSSFSheet s;
	XSSFRow r;
	XSSFCell cell;
	public int count;
			 
	public ExcelUtils(String path,String sheetname) throws Exception
	{
		FileInputStream fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		s=wb.getSheet(sheetname);
		count=s.getLastRowNum();
		System.out.println("****row count*******"+count);
	}
	public String getCellData(int rownum,int colnum)
	{
		return s.getRow(rownum).getCell(colnum).getStringCellValue();
		
	}
	public void setCellData(int row,int col,String result,String path) throws Exception
	{
		r=s.getRow(row);
	   cell=r.getCell(col);
	   if(cell==null)
	   {
		   cell=r.createCell(col);
		   cell.setCellValue(result);
	   }
	   else
	   {
		   cell.setCellValue(result);
	   }
	   FileOutputStream fos=new FileOutputStream(path);
	   wb.write(fos);
	   fos.close();
	}
	
}
