package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.Homepage;
import pages.LoginPage;
import utils.CommonUtiles;




public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private Driverfactory driverFactory;
	CommonUtiles commonUtiles;
	
	
	@Given("user navigates to Login Page")
	public void user_navigates_to_login_page() {
		 driverFactory=new Driverfactory();
		driver = driverFactory.Getdriver();
		Homepage homepage=new Homepage(driver);
		homepage.clickOnMyAccountDropMenu();
		loginpage=homepage.ClickOnLoginOption();
		
		//before
		/*driver = Driverfactory.Getdriver();
	    driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	    driver.findElement(By.linkText("Login")).click();*/
	}
	@When("user enter InValid email Address into email field")
	public void user_enter_InValid_email_Address_into_email_field() {
		
		// loginpage=new LoginPage(driver);
		 commonUtiles=new CommonUtiles();
		loginpage.EnterEmailAddress(commonUtiles.EmailTimestamp());
		
	}

	@When("^user enter Valid email Address (.+) into email field$")
	public void user_enter_valid_email_address_into_email_field(String validEmailtext) {

		// loginpage=new LoginPage(driver);
		loginpage.EnterEmailAddress(validEmailtext);
		
	   //driver.findElement(By.id("input-email")).sendKeys(validEmailtext);
	}

	@When("^user enter valid password (.+) into password field$")
	public void user_enter_valid_password_into_password_field(String ValidPasswordText) {
		//LoginPage loginpage=new LoginPage(driver);
	   loginpage.EnterPassword(ValidPasswordText);
		
	   //driver.findElement(By.id("input-password")).sendKeys(ValidPasswordText);
	}
	@When("user click on Login button")
	public void user_click_on_login_button() {
		//LoginPage loginpage=new LoginPage(driver);
		accountpage=loginpage.ClickONLoginButton();
	 // driver.findElement(By.xpath("//input[@value='Login']")).click(); 
	}

	@Then("user should Successfully Logged in")
	public void user_should_successfully_logged_in() {
		//AccountPage accountpage=new AccountPage(driver);
		 Assert.assertTrue(accountpage.LoggedAccountInformation());
		
		//Assert.assertTrue((driver.findElement(By.linkText("Edit your account information")).isDisplayed()));
	
	}
	@When("user enters invalid password {string} into the password field")
	public void user_enters_invalid_password_into_the_password_field(String invalidpassword) {
		//LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterPassword(invalidpassword);
		
		//driver.findElement(By.id("input-password")).sendKeys(invalidpassword);
	}
	

	@Then("user should not Logged in and get proper warning message")
	public void user_should_not_logged_in_and_get_proper_warning_message() {
		//LoginPage loginpage=new LoginPage(driver);
	    Assert.assertTrue(loginpage.DisplayStatusOnLoginPageWarningMSG().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	@When("user dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		//LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterEmailAddress("");
		//driver.findElement(By.id("input-email")).sendKeys("");
	}

	@When("user dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		//LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterPassword("");
		//driver.findElement(By.id("input-password")).sendKeys("");
	}
}
