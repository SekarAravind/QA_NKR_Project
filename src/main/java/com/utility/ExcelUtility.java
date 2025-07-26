package com.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static Object[][] getExcelData(String filePath, String SheetName){
		Object[][] data = null;
		try (FileInputStream fis = new FileInputStream(filePath)){
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(SheetName);
			int totalRows = sheet.getLastRowNum();
			short totalCols = sheet.getRow(0).getLastCellNum();
			data = new Object[totalRows][totalCols];
			
			for(int i=1; i<=totalRows; i++) {
				Row row = sheet.getRow(i);
				for (int j=0; j<totalCols; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = (cell == null) ? "" : cell.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
