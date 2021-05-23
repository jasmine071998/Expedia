package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	Workbook wb;
	public ExcelReader(String fileNameWithLocation) {
		
		
		try {
			if(fileNameWithLocation.endsWith(".xlsx")) {
				wb=new XSSFWorkbook(new FileInputStream(fileNameWithLocation));
			} else if(fileNameWithLocation.endsWith(".xls")) {
				wb=new HSSFWorkbook(new FileInputStream(fileNameWithLocation));
			}
			
		} catch (Exception e) {
			System.out.println("Error with file connection");
			System.out.println(e.getMessage());
		} 
		
	}
	
	public String getCellData(String sheetName,int row,int col) {
		
		String data=wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}
	
	public int getRowNum(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum()+1;
	}
	
	public int getColNum(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getLastCellNum();
	}
	
}
