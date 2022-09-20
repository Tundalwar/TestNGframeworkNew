package Com.Demosite.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Com.Demosite.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String useremail =readConfig.getUserEmail();
	public String usepassword =readConfig.getUserPassword();
	public static WebDriver driver;
	public static Logger logger;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test ;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = Logger.getLogger("Demosite");
		PropertyConfigurator.configure("Log4j.properties");
		
		 htmlReporter = new ExtentHtmlReporter("extent.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        test = extent.createTest(getClass().getName());
	        
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		driver = new ChromeDriver();
		}
		else if(br.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver",readConfig.getEdgePath());
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Browser are not valid");
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened");
		
	}
	
	public void TakesScreen() {
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File("D:\\Driver\\TestNGFrame\\Screenshots\\"+System.currentTimeMillis()+".png");
			FileHandler.copy(source, des);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Exception while Screenshot");
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		extent.flush();
	}

}
