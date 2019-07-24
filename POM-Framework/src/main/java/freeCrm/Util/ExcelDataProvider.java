package freeCrm.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	public ExcelDataProvider(){
		
		try {
			File f = new File(System.getProperty("user.dir")+"//TestData//ExcelSheet.xlsx");
			
			FileInputStream fis = new FileInputStream(f);
			
			wb = new XSSFWorkbook(fis);
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
			System.out.println("unable to read excel sheet");
		} 
		catch (IOException e) {

			e.printStackTrace();
		}
	}
	
public String getStringData(String sheetName, int row, int col){
		
		XSSFSheet sheet=wb.getSheet(sheetName);
		
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(int sheetIndex, int row, int col){
		
		XSSFSheet sheet=wb.getSheetAt(sheetIndex);
		
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public int getNumericData(String sheetName, int row, int col){
		
		XSSFSheet sheet= wb.getSheet(sheetName);
		
		return (int)sheet.getRow(row).getCell(col).getNumericCellValue();
	}
	
	public int getNumericData(int sheetIndex, int row, int col){
		
		XSSFSheet sheet= wb.getSheetAt(sheetIndex);
		
		return (int)sheet.getRow(row).getCell(col).getNumericCellValue();
	}
	
	public Object[][] getExcelData(String sheetName){
		
		XSSFSheet sheet= wb.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		
		short cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0; i<rows; i++){
			
			for(int j=0; j<cols; j++){
				
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
