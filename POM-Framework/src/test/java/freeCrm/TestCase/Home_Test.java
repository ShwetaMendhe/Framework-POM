package freeCrm.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import freeCrm.Base.TestBase;
import freeCrm.Pages.ContactPage;
import freeCrm.Pages.HomePage;
import freeCrm.Pages.LoginPage;
import freeCrm.Util.Helper;

public class Home_Test extends TestBase {

	LoginPage loginpage;
	ContactPage contactpage;
	HomePage homepage;
	Helper helper;
	
	public Home_Test(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		browserSetUp();
		
		contactpage = new ContactPage();
		
		helper = new Helper();
		
		loginpage = new LoginPage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/*@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homepage.verifyHomePageTitle();
		
		Assert.assertEquals(title, "CRMPRO", "HOME PAGE TITLE NOT MATCHED>>>");
	}*/
	
	@Test(priority=2)
	public void clickOnContactsLinkTest(){
		helper.switchToFrame();
		contactpage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		
}
