package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String path="C:\\selenium\\doc\\data.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheet("Sheet1");

		String cell00=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cell00);
		
		String cell01=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println(cell01);
		
		
		int rc=sheet1.getLastRowNum();
		System.out.println("Row Count: "+(rc+1));
		
			int ipc=sheet1.getRow(0).getLastCellNum();
			System.out.println("No: of inputs:= "+ipc);
			
			for(int k=0;k<ipc;k++)
			{
				String cell=sheet1.getRow(0).getCell(k).getStringCellValue();
				System.out.println("Input Parameters := "+cell );
				
			}

		
			sheet1.getRow(0).createCell(2).setCellValue("Result");
		
		for(int i=1;i<rc+1;i++)
		{
			int cc=sheet1.getRow(i).getLastCellNum();
			System.out.println("Row num: "+i+" Column Count: "+cc);
			
			for(int j=0;j<cc;j++)
			{
				String cell=sheet1.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cell);
				
			}
			
			sheet1.getRow(i).createCell(2).setCellValue("Pass");
			
			
		}
		
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		
		
		wb.close();
		

	}

}
