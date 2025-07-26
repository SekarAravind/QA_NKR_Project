package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class ReadExcelData {
	

	public static String readParticularCellData(int rowValue, int cellValue){
		
		String data = null;
		
		try {
			File file = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Selenium - Greens\\DataDriven_JAN.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(rowValue);
			Cell cell = row.getCell(cellValue);
			DataFormatter dataFormat =  new DataFormatter();
			data = dataFormat.formatCellValue(cell);
			System.out.println(data);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return data;
	}
	
}
