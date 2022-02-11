package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
 
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	 
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://mvnrepository.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  
  @Test
  public void f() throws InterruptedException {
	  
	 driver.findElement(By.id("query")).sendKeys("Selenium");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"search\"]/form/input[2]")).click();
	 Thread.sleep(1000);
  }
  
  @Test(dataProvider="Searches")
  public void test2(String search) throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[@id=\"search\"]/form/input[2]")).click();
		 Thread.sleep(1000);
	  System.out.println(search);
	  
  }
  
  @DataProvider(name="Searches")
  public Object[][] getData() {
	  Object[][] data = new Object[4][1];
	  
	  data[0][0]= "Selenium";
	  
	  data[1][0]= "apachepoi";
	  
	  data[2][0]= "maven";
	  
	  data[3][0]= "testng";
	  return data;
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
