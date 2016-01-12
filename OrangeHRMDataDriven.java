package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRMDataDriven {

	public static void main(String[] args) throws InterruptedException, Exception  {
	
				String path="C:\\selenium\\doc\\input.xlsx";
				
				FileInputStream fis=new FileInputStream(path);
				XSSFWorkbook wb=new XSSFWorkbook(fis);
				XSSFSheet sheet1=wb.getSheet("Sheet1");
								
				int rc=sheet1.getLastRowNum();
				System.out.println("Row Count: "+(rc+1));
				
				sheet1.getRow(0).createCell(2).setCellValue("Result");
				
				for(int i=1;i<rc+1;i++)
				{
					
						String user=sheet1.getRow(i).getCell(0).getStringCellValue();
						String pass=sheet1.getRow(i).getCell(1).getStringCellValue();
						
						WebDriver driver = new FirefoxDriver();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
				        driver.get("http://opensource.demo.orangehrm.com/");	
				        driver.manage().window().maximize();

						driver.findElement(By.id("txtUsername")).sendKeys(user);
						driver.findElement(By.id("txtPassword")).sendKeys(pass);
						driver.findElement(By.id("btnLogin")).click();

						if (driver.findElements(By.id("welcome")).isEmpty())
						{	
							System.out.println("Invalid Data : user:= "+user+" password:= "+pass);
							sheet1.getRow(i).createCell(2).setCellValue("Fail");
							
						}
						else
						{
							//driver.findElement(By.id("welcome")).click();
							//driver.findElement(By.xpath("//a[contains(@href, '/index.php/auth/logout')]")).click();
							System.out.println("Valid Data : user:= "+user+" password:= "+pass);
							sheet1.getRow(i).createCell(2).setCellValue("Pass");
						}
						
					    driver.quit();
				}
				
				
				FileOutputStream fos=new FileOutputStream(path);
				wb.write(fos);
				wb.close();
	}
}