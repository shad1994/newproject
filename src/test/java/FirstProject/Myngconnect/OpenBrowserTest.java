package FirstProject.Myngconnect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public  class OpenBrowserTest{
	
	@Test
	public void openbrowser() throws IOException, InterruptedException{
		
	
		InitialiseDriver init=new InitialiseDriver();
		WebDriver driver=init.initialisedriver();
	
		System.out.println("start");

		System.out.println("browser open");
		Thread.sleep(2000);
		driver.get("https://s-www.myngconnect.com/login/chooseMainUI.spr");
		WebElement educator = driver.findElement(By.id("imgEducators"));
		educator.click();
		//driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}


	
	
}
