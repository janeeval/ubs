package Day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoExcel {
	@Test 
	public void DemoExcelTest()
	{
	/*String exePath = "C:\\Users\\training_b4c.06.01\\J_P_Test\\Driver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", exePath);
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://demowebshop.tricentis.com/login");*/
	File file= new File("src\\test\\resources\\TestData.xlsx");
		
		try {
			InputStream is = new FileInputStream(file);
			XSSFWorkbook workbook= new XSSFWorkbook(is);
			XSSFSheet sheet1 = workbook.getSheet("Sheet1");
			for(int i=1;i<=sheet1.getLastRowNum();i++)
			{
				for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
				{
					System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue()+"\t\t");
				}
				
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}
}

