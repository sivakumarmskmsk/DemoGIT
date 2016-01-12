package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class CrossBrowser2 {
	String url="http://docs.seleniumhq.org/";
	
	WebDriver driver;


@Parameters({"browser"})
@BeforeClass

public void before(String browser)
{
	
	if(browser.equals("FF"))
	{
		driver=new FirefoxDriver();
	}
	else if(browser.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver","C:\\Selenium\\driver\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	else if(browser.equals("GC"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	driver.get(url);	
}

@AfterClass
public void afterclass()
{
	driver.quit();
	
}
@AfterMethod
public void after() throws Exception
{
	Thread.sleep(3000);
}


	  
@Test
 public void Link2() throws Exception {
	  
		driver.findElement(By.linkText("Projects")).click();
		  }

@Test
public void Link1() throws Exception {
	  
		driver.findElement(By.linkText("Support")).click();
	  }
}



