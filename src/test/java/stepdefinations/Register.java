package stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountCreatedSuccessPage;
import pages.Homepage;
import pages.RegisterPage;
import utils.CommonUtiles;

public class Register {
	WebDriver driver;
	private RegisterPage register;
	private AccountCreatedSuccessPage accountsuccsses;
	private Driverfactory driverfactory;
	private CommonUtiles coomonUtiles;
	
	
	
	@Given("user navigates to Register page")
	public void user_navigates_to_register_page() {
		 driverfactory=new Driverfactory();
	     driver = driverfactory.Getdriver();
	     Homepage homepage=new Homepage(driver);
	     homepage.clickOnMyAccountDropMenu();
	     register  = homepage.ClickOnRegisterOptions();
	     
	     /*driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	     driver.findElement(By.linkText("Register")).click();*/
	}

	@When("user enters the deatils to below field")
	public void user_enters_the_deatils_to_below_field(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		//RegisterPage register=new RegisterPage(driver);	
	register.EnterFirstNameText(dataMap.get("First Name"));
	register.EnterLastNameText(dataMap.get("lastname"));	
	 coomonUtiles =new CommonUtiles();
	register.EnterEmailText(coomonUtiles.EmailTimestamp());	
	register.EnterTelephoneText(dataMap.get("Telephone"));	
	register.EnterPassword(dataMap.get("Password"));	
	register.EnterConfirmPassword(dataMap.get("Confirm Password"));
	
	/*driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("First Name"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(EmailTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Confirm Password"));
		*/
	}
	@When("user select privacy policy check box")
	public void user_select_privacy_policy_check_box() {
		//RegisterPage register=new RegisterPage(driver);
		register.ClickOnPrivacyPolicyOptions();
		
		//driver.findElement(By.name("agree")).click();
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		//RegisterPage register=new RegisterPage(driver);
		accountsuccsses=register.ClickOnLoginButton();
		
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	@Then("user account should created succesfully")
	public void user_account_should_created_succesfully() {
		//AccountCreatedSuccessPage accountsuccsses=new AccountCreatedSuccessPage(driver);
	Assert.assertEquals(accountsuccsses.displayStatusOfAccountCreatedPage() ,"Your Account Has Been Created!");
    //Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).isDisplayed());

	}
	
	@When("user enters the duplicate deatils to below field")
	public void user_enters_the_duplicate_deatils_to_below_field(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		//RegisterPage register=new RegisterPage(driver);
		register.EnterFirstNameText(dataMap.get("First Name"));
		register.EnterLastNameText(dataMap.get("lastname"));
		register.EnterEmailText(dataMap.get("Email"));
		register.EnterTelephoneText(dataMap.get("Telephone"));
		register.EnterPassword(dataMap.get("Password"));
		register.EnterConfirmPassword(dataMap.get("Confirm Password"));
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("First Name"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("Email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Confirm Password"));*/
		}
	
	
	

	@When("user select YES for newsLatter")
	public void user_select_yes_for_news_latter() {
		//RegisterPage register=new RegisterPage(driver);
		register.SelectYesOption();
	 
		//driver.findElement(By.xpath("//input[@name='newsletter'] [@value='1']")).click();
	}

	@Then("user account shouldnt be created and get warning message")
	public void user_account_shouldnt_be_created_and_get_warning_message() {
		//RegisterPage register=new RegisterPage(driver);
	Assert.assertEquals("Warning: E-Mail Address is already registered!", register.AlreadyCreatedAccountWarningMessage());
		//Assert.assertEquals("Warning: E-Mail Address is already registered!", driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
	}

	

	@When("user dont enter any details into all the fields")
	public void user_dont_enter_any_details_into_all_the_fields() {
	   //no need enter any thing here keep it as empty
	}

	

	@Then("user Account shouldnt be created and get proper error message on every mandatory feilds")
	public void user_account_shouldnt_be_created_and_get_proper_error_message_on_every_mandatory_feilds() {
	   
		//RegisterPage register=new RegisterPage(driver);
		Assert.assertTrue(register.DisplayStatusOfPrivacyPolicyWarningMessage());
		Assert.assertTrue(register.DisplayStatusOFFirstNameTextFieldwarningMessage());
		Assert.assertTrue(register.displayStatusOfLastNameWarningMessage());
		Assert.assertTrue(register.DisplayStatusOfEmailWarningMessage());
		Assert.assertTrue(register.DispalyStatusOfTelephoneWarningMessage());
		Assert.assertTrue(register.DispalystatusOfPasswordWarning());
		
		
		/*Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains(" Warning: You must agree to the Privacy Policy!"));
			Assert.assertEquals("Warning: You must agree to the Privacy Policy!", driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
		Assert.assertEquals("First Name must be between 1 and 32 characters!" ,   driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText());  
	Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText());
	Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText());
	Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText());
	Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText());
	
	}

	/*private String EmailTimestamp() {
		Date date=new Date();
		return "nandi"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}*/
	
	}
}
