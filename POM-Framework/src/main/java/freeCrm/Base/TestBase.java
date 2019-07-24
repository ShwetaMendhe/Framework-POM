package freeCrm.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import freeCrm.Util.ExcelDataProvider;
import freeCrm.Util.Helper;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static ExcelDataProvider dataprovider;
	public ExtentReports extent;
	public ExtentTest logger; 
	
	@BeforeSuite
	public void beforeSuite(){
		
		dataprovider = new ExcelDataProvider();
		
		ExtentHtmlReporter reports=new ExtentHtmlReporter(new File
				(System.getProperty("user.dir")+".//Reports//freeCrm_"+Helper.getCurrentDateTime()+".html"));
		
		extent = new ExtentReports();
		
		extent.attachReporter(reports);	
	}

	//TO READ PROPERTIES FILE
	public TestBase(){
		
		try {
			File f = new File("C:\\Users\\Nano\\workspace\\POM-Framework\\"
					+ "src\\main\\java\\freeCrm\\Config\\Property.Properties");
			
			FileInputStream fis = new FileInputStream(f);
			
			prop = new Properties();
			
			prop.load(fis);
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
	public void browserSetUp(){
		
		String browser_name = prop.getProperty("browser");
		
		if(browser_name.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "D:\\Shweta\\SOFTWARE STUDY\\"
					+ "Selenium Driver\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();	
		}
		else if(browser_name.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "D:\\Shweta\\SOFTWARE STUDY\\"
					+ "Selenium Driver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();	
		}
		else{
			
			System.out.println("Browser doesn't match>>>>>>>");
		}
		
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//System.out.println("Title of the page is :"+driver.getTitle());
		
		driver.get(prop.getProperty("url"));	
	}
	
	//TO DESCRIBE THE RESULT OF TEST
	@AfterMethod
	public void tearDown(ITestResult results) throws IOException{
		
		if(results.getStatus() == ITestResult.FAILURE){
			
			Helper.captureScreenshots(driver);  //as it is static method,it is called by class name
			
			logger.fail("Failure Test", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			
		} else if(results.getStatus() == ITestResult.SUCCESS){
			
			Helper.captureScreenshots(driver);
			
			logger.pass("Test Passed");
		
		} else if (results.getStatus() == ITestResult.SKIP) {
			
			Helper.captureScreenshots(driver);
			
			logger.skip("Test Skipped");
		}
		
		extent.flush();
		driver.quit();
	}

	
}
