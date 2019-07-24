package freeCrm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import freeCrm.Base.TestBase;

public class RegPage extends TestBase {

	//2ND APPROACH---PAGE FACTORY: OBJECT REPOSITORY
	
	@FindBy(how = How.ID, using= "payment_plan_id")
	WebElement selectDD;
	
	 @FindBy(how = How.NAME, using = "first_name")
	 WebElement fname;
	 
	 @FindBy(how = How.NAME, using = "surname") 
	 WebElement lname;
	 
	 @FindBy(how = How.NAME, using = "email") 
	 WebElement eid;
	 
	 @FindBy(how = How.NAME, using = "email_confirm") 
	 WebElement confirmEid;
	 
	 @FindBy(how = How.NAME, using = "username") 
	 WebElement userName;
	 
	 @FindBy(how = How.NAME, using = "password") 
	 WebElement userPassword;
	 
	 @FindBy(how = How.NAME, using = "passwordconfirm") 
	 WebElement confirmUserPwd;
	 
	 @FindBy(how = How.NAME, using = "agreeTerms") 
	 WebElement checkBox;
	 
	 
	 @FindBy(how = How.NAME, using = "submitButton") 
	 WebElement submitBtn;
	 
	 public RegPage(){
		 
		 PageFactory.initElements(driver, this);
		 
	 }
	
	 public void createNewUser(String dd_Text, String firstname, String lastname, String EmailId,
			 String confirmEmailId, String usernm, String pwd, String confirmPwd){
		 
		 Select sel= new Select(selectDD);
		 
		 sel.selectByVisibleText(dd_Text);
		 
		 fname.sendKeys(firstname);
		 
		 lname.sendKeys(lastname);
		 
		 eid.sendKeys(EmailId);
		 
		 confirmEid.sendKeys(confirmEmailId);
		 
		 userName.sendKeys(usernm);
		 
		 userPassword.sendKeys(pwd);
		 
		 confirmUserPwd.sendKeys(confirmPwd);
		 
		 checkBox.click();
		 
		 submitBtn.click();
	 }
	 
	 
}
