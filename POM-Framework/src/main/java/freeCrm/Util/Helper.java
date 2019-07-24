package freeCrm.Util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import freeCrm.Base.TestBase;

public class Helper extends TestBase {

	static WebDriver driver;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	//TO TAKE A SCREENSHOT
	public static String captureScreenshots(WebDriver driver){
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath =  System.getProperty("user.dir")+".//Screenshots//freeCrm_"+getCurrentDateTime()+".png";
				
		try {
						
			FileHandler.copy(srcfile, new File("screenshotpath"));
			
			System.out.println("Check out the screenshot");
		}
		catch (IOException e) {

			e.printStackTrace();
			
			System.out.println("Unable to take the screenshot");
		}
		
		return screenshotpath;
	}

	//TO GET CURRENT DATE AND USED TO PRINT SCREENSHOT NAME
	public static String getCurrentDateTime() {

		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate = new Date();
		
		return customformat.format(currentdate);
	}
		
	
}
