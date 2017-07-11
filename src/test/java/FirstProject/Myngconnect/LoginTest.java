package FirstProject.Myngconnect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest{

	
	AccessProperty property=new AccessProperty();
	
	

	

	@Test(priority = 1)
	public void loginTest() throws InterruptedException, IOException, ParseException {
		
		datafiletype datatype=new datafiletype();
		datatype.DatafileType();
		
		Thread.sleep(5000);
		String username=datafiletype.username;
		String password=datafiletype.password;
	
		
		WebDriver driver =InitialiseDriver.driver;
		WebElement name = driver.findElement(By.id("j_username"));
		name.sendKeys(username);

		 Thread.sleep(2000);
	
		WebElement pswd = driver.findElement(By.id("passwordField"));
		pswd.sendKeys(password);

		
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("imgLogin")));
		 Thread.sleep(2000);
		
		WebElement login = driver.findElement(By.id("imgLogin"));
		login.click();
		

		 
		
		assertThat(driver.findElement(By.id("j_username")).getAttribute("value")).isEqualTo("LegacyEdgeStage1499326061460@qaittest.com");
		
		assertThat(driver.findElement(By.id("passwordField")).getAttribute("value")).isEqualTo("password");

		System.out.println("Welcome");
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='logout icon logout-ctrl header-sprite custom-tooltip']")));

	

	}
	
	@Test(priority =2)
	public void logout() throws InterruptedException
	{
		
		WebDriver driver=InitialiseDriver.driver;
		Thread.sleep(5000);
		System.out.println("logout");
		WebElement logout = driver
				.findElement(By.xpath("//div[@class='logout icon logout-ctrl header-sprite custom-tooltip']"));
		logout.click();
		
	}
	
	

}
