package freeCrm.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freeCrm.Base.TestBase;

public class LoginPage extends TestBase{

	//PAGE FACTORY : OBJECT REPOSITORY
	
	@FindBy(name="username")
	WebElement usernm;
	
	@FindBy(name= "password")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy(xpath= "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement logocrm;
	
	
	//INITIALISE THE PAGE OBJECT

		public LoginPage(){
			
			PageFactory.initElements(driver, this);
	
	}
		
	// ACTIONS

	public String validateLoginPageTitle(){
		
		return driver.getTitle();	
	}
	
	public boolean validateLogoCrm(){
		
		return logocrm.isDisplayed();
	}
	
	public HomePage login(String username, String pass){
		
		usernm.sendKeys(username);
		
		pwd.sendKeys(pass);
		
		loginbtn.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return new HomePage();
	}	
	
	public RegPage clickToSignUpLink(){
		
		//signupbtn.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",signupbtn);
		
		return new RegPage();
		
	}
		
}
