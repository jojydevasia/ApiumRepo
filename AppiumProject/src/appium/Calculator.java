package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME","Android");
		capabilities.setCapability("VERSION","5.0.2");
		capabilities.setCapability("deviceName","ZX1D62CWZJ");
		capabilities.setCapability("platformName","Android");
		
		capabilities.setCapability("appPackage","com.android.calculator2");
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
		
		
		driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	
	}
	
	@Test
	public void testCal() throws Exception{
			WebElement two= driver.findElement(By.name("2"));
			two.click();
			WebElement plus= driver.findElement(By.name("+"));
			plus.click();
			WebElement four=driver.findElement(By.name("4"));
			four.click();
			WebElement equals=driver.findElement(By.name("="));
			equals.click();
			
			WebElement results=driver.findElement(By.tagName("EditText"));
			
			Assert.assertTrue(results.getText().equals("8"),"Actual Value is:  "+results.getText() +" did not match with the Expected Value: 8");
			
	}  
		
		@AfterClass
		public void tearDown(){
			driver.quit();
		}
	

}
