package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//first name
	@FindBy(id="input-firstname")
	private WebElement FirstName;
	
	public void EnterFirstNameText(String FirstNameText) {
		FirstName.sendKeys(FirstNameText);
	}
	
	//LastName
	@FindBy(id="input-lastname")
	private WebElement lastnameText;
	
	public void EnterLastNameText(String LastnameText) {
		lastnameText.sendKeys(LastnameText);
	}
	
	//for enter email text
	@FindBy(id="input-email")
	private WebElement emailtext;
	
	public void EnterEmailText(String EmailText) {
		emailtext.sendKeys(EmailText);
	}
	
	//for enter telephone field
	@FindBy(id="input-telephone")
	private WebElement TelephoneField;
	
	public void EnterTelephoneText(String TelephoneText) {
		TelephoneField.sendKeys(TelephoneText);
	}
	
	//for enter password
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	public void EnterPassword(String PasswordText) {
		PasswordField.sendKeys(PasswordText);
	}
	
	//for confirm password
	@FindBy(id="input-confirm")
	private WebElement ConfirmPassword;
	
	public void EnterConfirmPassword(String ConfirmPassswordText) {
		ConfirmPassword.sendKeys(ConfirmPassswordText);
	}
	
	//privacyPolicy Option
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacypolicy;
	
	public void ClickOnPrivacyPolicyOptions() {
		privacypolicy.click();
	}
	
	//for clicking login buttom
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement LoginButton;
	
	public AccountCreatedSuccessPage ClickOnLoginButton() {
		LoginButton.click();
		return new AccountCreatedSuccessPage(driver);
	}
	
	//for select yes options
	@FindBy(xpath="//label[normalize-space()='Yes']//input[@name='newsletter']")
	private WebElement YesOption;
	
	public void SelectYesOption() {
		YesOption.click();
	}
	
	//for Email Already created warning  message
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement AlredyCreatedAccountWarningMessage;
	
	public String AlreadyCreatedAccountWarningMessage() {
	return	AlredyCreatedAccountWarningMessage.getText();
	}
	
	//privacy policy warning mesage
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement PrivacypolicyWarningMessage;
	
	public boolean DisplayStatusOfPrivacyPolicyWarningMessage() {
		return PrivacypolicyWarningMessage.isDisplayed();
	}
	
	//first name warning message
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement FirstNameWarning;
	
	public boolean DisplayStatusOFFirstNameTextFieldwarningMessage() {
		return FirstNameWarning.isDisplayed();
	}
	
	//lastName TextField warning message
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement LastNamewarning;
	
	public boolean displayStatusOfLastNameWarningMessage() {
		return LastNamewarning.isDisplayed();
	}
	
	// email warning message
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	public boolean DisplayStatusOfEmailWarningMessage() {
		return emailWarning.isDisplayed();
	}
	
	//Telephone warning message
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement Telephonewarning;
	
	public boolean DispalyStatusOfTelephoneWarningMessage() {
		return Telephonewarning.isDisplayed();
	}
	
	//password warning message
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement Passwordwarning;
	
	public boolean DispalystatusOfPasswordWarning() {
		return Passwordwarning.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
