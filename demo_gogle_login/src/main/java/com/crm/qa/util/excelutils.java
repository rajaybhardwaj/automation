package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static void setExcelFile(String ExcelFilePath, String ExcelSheet) throws Exception 
	{
		FileInputStream File = new FileInputStream(ExcelFilePath);
		wb = new XSSFWorkbook(File);
	}
	
	public static int CountRow(String ExcelFilePath, String ExcelSheet) throws Exception
	{
		fi = new FileInputStream(ExcelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(ExcelSheet);
		int LastRow = ws.getLastRowNum();
		
		
		return LastRow;
	}
	
	public static int CountColumn(String ExcelFilePath, String ExcelSheet, int rownumber) throws Exception
	{
		fi = new FileInputStream(ExcelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(ExcelSheet);
		row = ws.getRow(rownumber);
		int cellCount = row.getLastCellNum();
		return cellCount;
	}
	
	public static String cellData(String ExcelFilePath, String ExcelSheet, int rownumber,int cellnumber) throws Exception
	{
		fi = new FileInputStream(ExcelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(ExcelSheet);
		row = ws.getRow(rownumber);
		cell = row.getCell(cellnumber);
		
		
		String data;
		try {
			DataFormatter FormatData = new DataFormatter();
			String cellDataValue = FormatData.formatCellValue(cell);
			return cellDataValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			data="No Data Found, its the catch statement";
			e.printStackTrace();
		}
		return data;
		
	}
	
	public static void writeinCell(String ExcelFilePath, String ExcelSheet, int rownumber,int cellnumber,String data) throws Exception
	{
		fi = new FileInputStream(ExcelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(ExcelSheet);
		row = ws.getRow(rownumber);
		cell = row.getCell(cellnumber);
		cell.setCellValue(data);
		fo = new FileOutputStream(ExcelFilePath);
		wb.write(fo);
	}
	
}
