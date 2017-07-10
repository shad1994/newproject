package FirstProject.Myngconnect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class logoutTest extends InitialiseDriver{
	
	@Test
	public void logout() throws InterruptedException
	{
		WebElement logout = driver
				.findElement(By.xpath("//div[@class='logout icon logout-ctrl header-sprite custom-tooltip']"));
		logout.click();
		Thread.sleep(2000);
		driver.close();
	}

}
