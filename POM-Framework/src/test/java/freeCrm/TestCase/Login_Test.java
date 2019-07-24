package freeCrm.TestCase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import freeCrm.Base.TestBase;
import freeCrm.Pages.HomePage;
import freeCrm.Pages.LoginPage;
import freeCrm.Util.ExcelDataProvider;
import freeCrm.Util.Helper;

public class Login_Test extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	public ExcelDataProvider dataprovider;
	
	public Login_Test(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		browserSetUp();
		
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest(){
		logger = extent.createTest("started validate login page title test");
		logger.info("validating title-----");
		String title= loginpage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "CRMPRO1 - CRM software for customer relationship management, sales, and support.");
		logger.pass("test passed");
		Helper.captureScreenshots(driver);
		//Assert.assertTrue(title.contains("CRMPRO"), "TITLE OF THE PAGE DOESN'T MATCH-----");
				
	}
	
	/*@Test(priority=2)
	public void crmLogo(){
		
		boolean flag = loginpage.validateLogoCrm();
		
		Assert.assertTrue(flag);
		
	}*/
	
	@Test(priority=3)
	public void login_Test(){
		
		logger = extent.createTest("Start test");
		
		logger.info("starting the test");
		
		//1st approach with values from Property.properties file
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		logger.pass("Login successful");
		
		//2nd approach with values from excel sheet with name "ExcelSheet"
		
		//loginpage.login(dataprovider.getStringData("sheet1", 1, 0), dataprovider.getStringData("sheet1", 1, 1));
		
		Helper.captureScreenshots(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	/*@AfterMethod
	public void endUp(){
		
		driver.quit();
		
	}*/
}
