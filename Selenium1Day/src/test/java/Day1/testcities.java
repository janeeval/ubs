package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcities {
	@Test
	public void testcity() throws InterruptedException
	{
		String exePath = "C:\\Users\\training_b4c.06.01\\J_P_Test\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		WebElement from = driver.findElement(By.id("FromTag"));
		Actions Act1= new Actions(driver);
		Thread.sleep(5000);
		Act1.sendKeys(from, "hyd").perform();
		Thread.sleep(5000);
		Act1.sendKeys(Keys.ENTER).perform();
		
		String city= driver.findElement(By.id("From")).getAttribute("value");
		Assert.assertEquals(city, "HYD");
		driver.quit();
	}
 
}
