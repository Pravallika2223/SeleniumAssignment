package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TextNoSendkeys {
 
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/index.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }
  @Test
  public void f() throws InterruptedException {
	 
	  // JavaScript Executor to enter text
      JavascriptExecutor j = (JavascriptExecutor)driver;
     // j.executeScript("document.getElementById('gsc-i-id1').value='Selenium'");
      j.executeScript("document.getElementById('search-strings').value='Selenium Online Training'");
      Thread.sleep(5000);
      WebElement web = driver.findElement(By.id("search-strings"));
      Thread.sleep(5000);
      String s = web.getAttribute("value");
      System.out.println("Value entered is: " + s);
      
  }
  @AfterMethod
  public void afterMethod() {
	  
	  
	  driver.quit();
  }

}
