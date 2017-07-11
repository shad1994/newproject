package FirstProject.Myngconnect;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class InitialiseDriver {
	public static WebDriver driver;
	AccessProperty property = new AccessProperty();
	String browser;

	//@Test
	public WebDriver initialisedriver() throws IOException  {
		browser = property.getproperty("Browser");

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/qainfotech/workspace/TestNG/resources/geckodriver");

			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");

			driver = new ChromeDriver();
		}
		 return driver;

	
	}
	

}
