package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Alert {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  @Test
  public void f() throws InterruptedException {
	  
	  driver.findElement(By.id("fakealert")).click();
	  Thread.sleep(5000);
	  //driver.switchTo().alert().accept();
	  
	  driver.findElement(By.xpath("//*[@id=\"dialog-ok\"]")).click();
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
