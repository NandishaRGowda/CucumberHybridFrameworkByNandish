package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driverfactory {
	static WebDriver driver;
	
	public  WebDriver InitializeBrowser(String SRNBrowsername) {
		
		
		if(SRNBrowsername.equalsIgnoreCase("Chrome")) {
			 driver=new ChromeDriver();
			}
		else if(SRNBrowsername.equalsIgnoreCase("Firefox")) {
			 driver =new FirefoxDriver();
		}
		else if(SRNBrowsername.equalsIgnoreCase("edge")) {
			 driver =new EdgeDriver();
		}
		else if(SRNBrowsername.equalsIgnoreCase("safari")) {
			 driver =new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
			}
	
	public  WebDriver Getdriver(){
		return driver;
	
	}
	
}
