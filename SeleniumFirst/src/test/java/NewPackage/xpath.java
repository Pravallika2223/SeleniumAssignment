package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class xpath {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }
  @Test
  public void f() throws InterruptedException {
	  
	  driver.findElement(By.name("q")).sendKeys("Selenium");
	  List<WebElement> webElement = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
	  for(int i=0; i<webElement.size();i++)
	  {
		 String value = webElement.get(i).getText();
		 if(value.contains("java jdk"))
		 {
			 Thread.sleep(3000);
			 webElement.get(i).click();
			 break;
		 }
		  
	  }  
	  
  }
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
