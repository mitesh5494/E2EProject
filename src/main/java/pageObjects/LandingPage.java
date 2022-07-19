package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//login button
	@FindBy(xpath="//a/span[contains(.,'Login')]")
	private WebElement loginbutton;
	//validate title 
	@FindBy(xpath="//div[@class='text-center']/h2")
	private WebElement title;
	//validate navigation bar
	@FindBy(css=".nav.navbar-nav.navbar-right li a")
	private WebElement navbar;
	// validate header title
	@FindBy(css="div[class*='video-banner'] h3 ")
	private WebElement headertitle;
	
	
	
	

	

	public LoginPage login()
	{
		loginbutton.click();
		return new LoginPage(driver);
		
	}
	public WebElement getTitle()
	{
		return title;
	}
	
	public WebElement validateNavigationBar()
	{
		return navbar;
	}
	public WebElement validateHeaderTitle()
	{
		return headertitle;
	}
}
