package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class NewTab {
  String uri = "http://openclinic.sourceforge.net/openclinic/medical/index.php";
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]/a")).click();
	  driver.switchTo().newWindow(WindowType.TAB);
	  Thread.sleep(1000);
	  driver.get(uri);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]/a")).click();
	  WebElement web = driver.findElement(By.id("search_type"));
	  Select slc = new Select(web);
	  slc.selectByVisibleText("First Name");
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("search_patient")).click();
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
