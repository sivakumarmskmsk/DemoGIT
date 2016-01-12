package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		String path="C:\\selenium\\doc\\data.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheet("Sheet1");
		
		sheet1.getRow(0).createCell(2).setCellValue("Result");
		sheet1.getRow(1).createCell(2).setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		
		wb.close();
		
		
				
		
		

	}

}
