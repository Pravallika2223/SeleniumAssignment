package NewPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Excel {
 
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
@Test
  public void f() throws Exception {
	  
	  String path = "C:\\Users\\Praveen\\Desktop\\Book1.xlsx";
	  FileInputStream fileStream = new FileInputStream(path);
	  XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
	  XSSFSheet sheet = workbook.getSheet("Sheet1");
	  int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	  System.out.println("no of rows : "+ rowCount);
	  for (int i = 1; i <= rowCount; i++)
	  {
		  String Searches = sheet.getRow(i).getCell(0).getStringCellValue();
		  System.out.println("the search is: "+ Searches);
		  
		  driver.findElement(By.id("search-strings")).sendKeys(Searches);
		  
		  String beforeloginurl= driver.getCurrentUrl();
		  System.out.println("the before login url is : "+ beforeloginurl);
		  
		  driver.findElement(By.xpath("//*[@id=\"btnSearch\"]/i")).click();
		  driver.navigate().back();
		  
		  String afterloginurl= driver.getCurrentUrl();
		  System.out.println("the after login url is : "+ afterloginurl);
		  
		  Row currentrow = sheet.getRow(i);
		  Cell status = currentrow.createCell(1);
		  
		 if(!afterloginurl.equals(beforeloginurl)) 
		 {
			 System.out.println("course not available");
			 status.setCellValue("course not available");
		 }
		 else
		 {
			 System.out.println("course is available");
			 status.setCellValue("course is available");
			 
		 } 
		 
		 FileOutputStream xplot = new FileOutputStream(path);
		 workbook.write(xplot);
		 xplot.close();
		 Thread.sleep(1000);
	  }
			
			Thread.sleep(2000);
	  
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
