package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class pincode {
  
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://chennaiiq.com/chennai/pincode_by_postal.asp");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }
  @Test
  public void f() {          
	  
	WebElement pin1 =  driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[4]/td[3]"));
	WebElement pin2 =  driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[17]/td[3]"));
	
	if(pin1.equals(pin2)) {
		System.out.println("two places have same pin");
		System.out.println("pin is : "+pin1);
	}
	else
	{
		System.out.println("pin is different");
		/*System.out.println("pin1 is :" + pin1);
		System.out.println("pin2 is :" + pin2);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[4]/td[3]")).getTagName();
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[17]/td[3]")).getTagName(); */
	}
	
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
