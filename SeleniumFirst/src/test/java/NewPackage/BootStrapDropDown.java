package NewPackage;

import org.testng.annotations.Test;

import net.bytebuddy.jar.asm.Label;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.Span;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BootStrapDropDown {
  WebDriver driver;
  @SuppressWarnings("deprecation")
@BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://the-internet.herokuapp.com/dropdown");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  
  @Test
  public void f() throws InterruptedException {
	
	  WebElement we = driver.findElement(By.id("dropdown"));
	  Thread.sleep(5000);
	  Select slc = new Select(we);
	  Thread.sleep(5000);
	  slc.selectByVisibleText("Option 1");
	  Thread.sleep(5000);
	  System.out.println("Option 1 is selected from the dropdown");
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
