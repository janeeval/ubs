package Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCity {
	
	@Test
	public void testCities() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		
		WebElement from=driver.findElement(By.id("FromTag"));
		Actions act1=new Actions(driver);
		Thread.sleep(5000);
		act1.keyDown(from,Keys.SHIFT).perform();
		Thread.sleep(5000);
		act1.sendKeys("hyd").perform();
		Thread.sleep(5000);
		act1.sendKeys(Keys.ENTER).perform();
	
		String city=driver.findElement(By.id("From")).getAttribute("value");
		Assert.assertEquals(city,"HYD");
		
		
		WebElement to=driver.findElement(By.id("ToTag"));
		to.sendKeys("bangk");
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-2")));
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		List<WebElement> list=ul.findElements(By.tagName("li"));
		Assert.assertEquals(2,list.size());
		for(WebElement li:list)
		{
			if(li.getText().contains("BKK"))
			{
				li.click();
				break;
			}
		}
		
		
	}

}
