package freeCrm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freeCrm.Base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	//Page Object initialization
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactPage();
	}
	
	public void clickonContactsLink(){
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
}
