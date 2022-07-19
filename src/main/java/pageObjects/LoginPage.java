package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Username
	@FindBy(xpath="//input[@type='email']")
	private WebElement username;
	//Password
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	//Login button
	@FindBy(xpath="//input[@name='commit']")
	private WebElement loginbutton;
	@FindBy(css=".link-below-button")
	private WebElement forgotpassbutton;
	
	
	
	public WebElement username()
	{
		return username;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement loginButton()
	{
		return loginbutton;
	}
	public ForgotPassword forgotPassbutton()
	{
		 forgotpassbutton.click();
		 return  new ForgotPassword(driver);
		
		
	}
	
}
