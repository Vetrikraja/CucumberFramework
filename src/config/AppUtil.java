package config;

import java.io.FileInputStream;
import java.util.Properties;
import org.checkerframework.common.util.report.qual.ReportCall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static WebDriver driver;
public static Properties conpro;
@BeforeTest
public void setUp() throws Throwable
{
	conpro = new Properties();
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if (conpro.getProperty("browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
	}
	else if (conpro.getProperty("browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();	
	}
	else 
	{
   Reporter.log("Browser value is not matching",true);
	}
}
@AfterTest
public void tearDown()
{
	driver.quit();
}
}

