package neogrowth.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Base {
	
	public static  WebDriver driver;
	public Properties config;
public WebDriver initializeDriver() throws IOException
{
	
 config= new Properties();
 //System.getProperty("user.dir")
 FileInputStream fis=new FileInputStream("./Utilities\\config.properties");

config.load(fis);
//mvn test -Dbrowser=chrome

//String browserName=System.getProperty("browser"); 
String browserName=config.getProperty("browser");
System.out.println(browserName);

if(browserName.contains("chrome"))
{
	 System.setProperty("webdriver.chrome.driver",config.getProperty("chromedriverpath"));
	 ChromeOptions options =new ChromeOptions();
	 if(browserName.contains("headless"))
	 {
	  options.addArguments("headless");
	 }
driver= new ChromeDriver(options);
		
	
}
else if (browserName.equals("firefox"))
{
	
	//firefox code
}
else if (browserName.equals("Edge"))
{
//	Edge code
}
driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
return driver;

}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;

}

}
