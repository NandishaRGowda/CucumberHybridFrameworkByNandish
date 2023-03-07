package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;
import pages.SearchResultPage;

public class Search {
	WebDriver driver;
	private SearchResultPage searchpage ;
	private Driverfactory driverFactory;
	
	
	//updated
	@Given("user opens the Application")
	public void user_opens_the_application() {
		 driverFactory=new Driverfactory();
		driver = driverFactory.Getdriver();
		
	}

	@When("user enter valid product {string} into searcxh field")
	public void user_enter_valid_product_into_searcxh_field(String validProductText) {
		Homepage homepage=new Homepage(driver);
		homepage.EnterProductName(validProductText);
	   
		//driver.findElement(By.name("search")).sendKeys(validProductText);
	}

	@When("user clicks on Search button")
	public void user_clicks_on_search_button() {
		Homepage homepage=new Homepage(driver);
		 searchpage = homepage.ClickOnSearchButton();
		
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	@Then("Valid product displayed in search results")
	public void valid_product_displayed_in_search_results() {
		//SearchResultPage searchpage=new SearchResultPage(driver);
	   Assert.assertTrue(searchpage.DispalyStatusOfProduct());
		
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("user enter INvalid product {string} into searcxh field")
	public void user_enter_i_nvalid_product_into_searcxh_field(String InvalidProductText) {
		Homepage homepage=new Homepage(driver);
		homepage.EnterProductName(InvalidProductText);
		//driver.findElement(By.name("search")).sendKeys(InvalidProductText);
	}
	
	
	
	@Then("user should get a warning message about no product matching")
	public void user_should_get_a_warning_message_about_no_product_matching() {
		//SearchResultPage searchpage=new SearchResultPage(driver);
	   Assert.assertTrue(searchpage.DispalyStatusOfInvalidProductWarning());
		
	   //driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).isDisplayed();
	}

	@When("user dont enter any product into searcxh field")
	public void user_dont_enter_any_product_into_searcxh_field() {
			//ignore Intentianaly
	}

	

}
