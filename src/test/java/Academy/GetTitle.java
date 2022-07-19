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

public class GetTitle extends Base {
	public WebDriver driver;
	 LandingPage l;
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	
	  @BeforeTest
	    public void intialize() throws IOException
	    {
	    	driver=initializeDriver();
			driver.get(prop.getProperty("url"));
	    }
	@Test
	public void validateTitle() throws IOException
	{
		
		 l = new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Text verified");
	}
	@Test
	public void validateHeader() throws IOException
	{
		l = new LandingPage(driver);
		Assert.assertEquals(l.validateHeaderTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
	    
	}
	
	@AfterTest
	public void driverClose()
	{
		driver.close();
	}
	
	
}
