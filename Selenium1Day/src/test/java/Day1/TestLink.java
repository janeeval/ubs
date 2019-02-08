package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLink {
	@Test 
	public void LinkTest()
	{   
		
	    String exePath = "C:\\Users\\training_b4c.06.01\\J_P_Test\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		try

		{

			driver.findElement(By.id("div-close")).click();

		}catch(Exception e){

			System.out.println("Ad is not dispalyed");

		}
		 	
		Actions Act1 = new Actions(driver);
		Act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']")));
		Act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
		Act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
		Act1.click(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
		Act1.perform();
		
		String CCUrl = driver.getCurrentUrl();
		Assert.assertTrue(CCUrl.contains("credit_cards"));
		
	}
}
