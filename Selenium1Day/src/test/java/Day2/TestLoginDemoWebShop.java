package Day2;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

	public class TestLoginDemoWebShop {
		WebDriver driver;
		  
		  @Parameters("browser")
		  @BeforeTest
		  public void beforeTest(String browser) 
		  {

			  if(browser.equals("chrome")) {
			 
				String exePath = "C:\\Users\\training_b4c.06.01\\J_P_Test\\Driver\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", exePath);
				driver= new ChromeDriver();
			 
			  }
			  else if (browser.equals("ie")) { 
			 
				String exePath = "C:\\Users\\training_b4c.06.01\\J_P_Test\\Driver\\IEDriverServer.exe";			    
			    System.setProperty("webdriver.ie.driver", exePath);
				driver = new InternetExplorerDriver();
			 
			  }
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  driver.get("http://demowebshop.tricentis.com/login");
			  
			  
		  }
		
		@Test(dataProvider="dp1")
		public void testDemoWebShopLogin(String username,String password)
		{
			driver.findElement(By.linkText("Log in")).click();
			driver.findElement(By.id("Email")).sendKeys(username);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.cssSelector("input[value='Log in']")).click();
			Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
			driver.findElement(By.linkText("Log out")).click();
		}
		@DataProvider(name="dp1")
		public Object[][] getData()
		{
			return TestReadExcel.testreadExcel();
		}
		@AfterTest
		public void afterclass()
		{
			driver.close();
		}

}
