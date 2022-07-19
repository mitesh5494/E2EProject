package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void intialize() throws IOException
    {
    	driver=initializeDriver();
		
    }
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LoginPage lp=l.login();
		//LoginPage lp= new LoginPage(driver);
		lp.username().sendKeys(username);
		lp.password().sendKeys(password); 
	    lp.loginButton().click();
		log.info("login");
		
		ForgotPassword fp=lp.forgotPassbutton();
		fp.getEmail().sendKeys("mitesh");
		fp.sendMeInstruction().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data test should run /left[]row 
		//column stands for how many values per each test //column [] right side
		Object[][] data=new Object[2][2];
		data[0][0]="mitesh"; 	
		data[0][1]="zz";
		
		data[1][0]="as";
		data[1][1]="zzz";
		return data;
	}
	@AfterTest
	public void driverClose()
	{
		driver.close();
	}
	
	
}
