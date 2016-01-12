package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\selenium\\doc\\data.xlsx");
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

		
		
		for(int i=1;i<rc+1;i++)
		{
			int cc=sheet1.getRow(i).getLastCellNum();
			System.out.println("Row num: "+i+" Column Count: "+cc);
			
			for(int j=0;j<cc;j++)
			{
				String cell=sheet1.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cell);
				
			}
			
		}
		
		wb.close();
		

	}

}
