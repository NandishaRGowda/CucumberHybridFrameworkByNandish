package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);	//used for initialize the webElement in the page level
	}
	
	//for clicking the my account dropmenu
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	
	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();
	}
	
	//for clicking the lohginOption
		@FindBy(linkText="Login")
		WebElement LoginOption;
		
		public LoginPage ClickOnLoginOption() {
			LoginOption.click();
			return new LoginPage(driver);
		}
		
	
		//for clicking the Register Page options
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
		private WebElement RegisterOptions;
		
		public RegisterPage ClickOnRegisterOptions() {
			RegisterOptions.click();
			return new RegisterPage(driver);
		}
		
		//searchField
		@FindBy(xpath="//input[@placeholder='Search']")
		private WebElement Searchfeled;
		
		public void EnterProductName(String ProductText) {
			Searchfeled.sendKeys(ProductText);
		}
		
		//user click on search button
		@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
		private WebElement SearchButton;
		
		public SearchResultPage ClickOnSearchButton() {
			SearchButton.click();
			return new SearchResultPage(driver);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
