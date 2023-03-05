package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//search product
	@FindBy(xpath="//a[normalize-space()='HP LP3065']")
	private WebElement ProductDetails;
	
	public boolean DispalyStatusOfProduct() {
		return ProductDetails.isDisplayed();
	}
	
	//invalid Product warning message
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement invalidProductWarning;
	
	public boolean DispalyStatusOfInvalidProductWarning() {
		return invalidProductWarning.isDisplayed();
	}
	
	
	
}


