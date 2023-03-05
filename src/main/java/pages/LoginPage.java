package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//for enter Valid email adress
	@FindBy(id="input-email")
	private WebElement EmailAddress;
	
	public void EnterEmailAddress(String EmailText) {
		EmailAddress.sendKeys(EmailText);
	}

	//for enter password
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	public void EnterPassword(String PasswordTEXT) {
		PasswordField.sendKeys(PasswordTEXT);
	}
	
	//for clicking LoginButton
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	public AccountPage ClickONLoginButton() {
		LoginButton.click();
		return new AccountPage(driver);
		}
	
	//for warning message when you enter invalid credentials
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningMessageField;
	
	public  String DisplayStatusOnLoginPageWarningMSG() {
		return WarningMessageField.getText();
	}
}
