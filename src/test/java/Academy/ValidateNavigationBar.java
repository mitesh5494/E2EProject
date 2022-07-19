package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	 LandingPage l;
	  @BeforeTest
	    public void intialize() throws IOException
	    {
	    	driver=initializeDriver();
			driver.get(prop.getProperty("url"));
	    }
	@Test
	public void basePageNavigation() throws IOException
	{
	
		l = new LandingPage(driver);
		
		Assert.assertTrue(l.validateNavigationBar().isDisplayed());
		log.info("Navigation bar is Displayed");
		
		
	
	    
	    
	    
	    
	    
	}
	
	
	
	@AfterTest
	public void driverClose()
	{
		driver.close();
	}
}
