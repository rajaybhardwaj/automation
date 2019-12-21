package com.crm.qa.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readtestdata  {
	
	public void readData() throws Exception
	{
	FileInputStream File = new FileInputStream("C://Users/hp/Desktop/Book.xlsx");
	XSSFWorkbook workbook = new  XSSFWorkbook(File);
	XSSFSheet Sheet = workbook.getSheet("Sheet 1");
	
	//count the number of rows and columns
	int RowNum = Sheet.getLastRowNum();
	int ColumnNum = Sheet.getRow(0).getLastCellNum();
	
	for(int row =0; row<=RowNum;row++) 
	{
	XSSFRow rowdata = Sheet.getRow(row);
		for(int column = 0; column<=ColumnNum;column++ ) 
		{
			XSSFCell celldata = rowdata.getCell(column);
			celldata.toString();		}
		
	}

	
	}
	
	

}
