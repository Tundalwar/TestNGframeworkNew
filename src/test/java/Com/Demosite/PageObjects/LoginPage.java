package Com.Demosite.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver Cdriver)
	{
		driver = Cdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[contains(text(),'Login')])[2]")
	@CacheLookup
   WebElement loginButton;
	
	@FindBy(xpath="//input[@id='input-email']")
	@CacheLookup
	 WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	@CacheLookup
	 WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	@CacheLookup
	private WebElement clickOnLogin;
	
	public void clickLoginButtton()
	{
		loginButton.click();
	}
	
	public void setUserEmail(String Useremail)
	{
		email.sendKeys(Useremail);
	}
	
	public void setUserPassword(String UserPass)
	{
		password.sendKeys(UserPass);
	}
	public void clickOnSubmit()
	{
		clickOnLogin.click();
	}
	
	
	
}
