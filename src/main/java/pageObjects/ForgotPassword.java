package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

	
	WebDriver driver;
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//get email
	@FindBy(css="#user_email")
	private WebElement email;
	//send me instruction button
	@FindBy(css="input[value='Send Me Instruction']")
	private WebElement sendmeinstruction;
	
	
	public WebElement getEmail()
	{
		return email;

	}
	public WebElement sendMeInstruction()
	{
		return sendmeinstruction;

	}
}

