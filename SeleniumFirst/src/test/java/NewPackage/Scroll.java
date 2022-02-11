package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Scroll {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.zomato.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  @Test
  public void f() {
	  
	  JavascriptExecutor js = ((JavascriptExecutor) driver);
	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
