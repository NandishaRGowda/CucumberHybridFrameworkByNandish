package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class hooksSetup  {
	WebDriver driver;
	private ConfigReader configReader;
	private Driverfactory driverFactory;
	
	@Before
	public void setup() {
		 configReader=new ConfigReader();
		Properties prop = configReader.InitializeProperties();
		
		driverFactory=new Driverfactory();
		driver=driverFactory.InitializeBrowser(prop.getProperty("browserName"));
		 //driver =Driverfactory.Getdriver();
		
		
		driver.get(prop.getProperty("url"));
	
		
		
		//before hard coding
		/*Driverfactory a=new Driverfactory();
		a.InitializeBrowser("Chrome");*/
		/* Driverfactory.InitializeBrowser("chrome");
		 driver =	Driverfactory.Getdriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.tutorialsninja.com/demo/");*/
	}
	
	
	
	
	
	@After
	public void TearDown(Scenario scenario) {
		String scenarioName=scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
            byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenshot, "image/png", scenarioName);
		
		}
		
		
		//driver=Driverfactory.Getdriver();
		driver.quit();
	}
	
	
	
}


