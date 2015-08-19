package com.mentor.utilities;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//This code will be modified, please do not touch it

public class ExcelReader {

		public int getExcelRowCount(String xlPath,String sheetName)
		{
			try
			{
				FileInputStream fis=new FileInputStream(xlPath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet(sheetName);
				int rc=s.getLastRowNum();
				return rc;
			}
			catch(Exception e)
			{
				return -1;
			}
		}
		
		public String getCellValue(String xlpath,String sheetName, int rownum,int cellnum)
		{
			try
			{
				FileInputStream fos = new FileInputStream(xlpath);
				Workbook wb = WorkbookFactory.create(fos);
				String strvalue =
				wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
				return strvalue;
			}
			catch(Exception e)
			{
				return"";
			}
		}
	}