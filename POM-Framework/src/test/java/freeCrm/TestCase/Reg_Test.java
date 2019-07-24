package freeCrm.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freeCrm.Base.TestBase;
import freeCrm.Pages.LoginPage;
import freeCrm.Pages.RegPage;
import freeCrm.Util.Helper;

public class Reg_Test extends TestBase{
	
	LoginPage loginpage;
	RegPage regpage;
	
	@BeforeMethod
	public void setUp(){
		
		browserSetUp();
	
		loginpage = new LoginPage();
		
		regpage = loginpage.clickToSignUpLink();
		
	}
	
	@Test(dataProvider= "getExcelData")
	public void createNewUser_Test(String dd_Text, String firstname, String lastname, String EmailId,
			 String confirmEmailId, String usernm, String pwd, String confirmPwd){
		
		Helper.captureScreenshots(driver);
		
		//regpage.createNewUser("Edition", "Vasant", "Chavan","vasant@gmail.com", "vasant@gmail.com","Vasant", "Vasant@123", "Vasant@123");
		
		regpage.createNewUser(dd_Text, firstname, lastname, EmailId, confirmEmailId, usernm, pwd, confirmPwd);
		
		Helper.captureScreenshots(driver);
		
	}
	
	@DataProvider
	public Object[][] getExcelData(){
		
		return dataprovider.getExcelData("sheet2");
	
	}
	
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/

}
