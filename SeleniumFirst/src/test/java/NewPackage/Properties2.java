package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Properties2 {
  
  WebDriver driver;
  static Properties properties = new Properties();
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();  
	  
  }
  @Test
  public void f() throws InterruptedException, IOException {
	  FileInputStream inputstream = new FileInputStream("C:\\Users\\Praveen\\eclipse-workspace\\SeleniumFirst\\src\\test\\resources\\properties\\Properties2.properties");
	   properties.load(inputstream);
	   String  out = properties.getProperty("url");
	   System.out.println(out);
	   
	   driver.get(out);
	   driver.manage().window().maximize();
	   Thread.sleep(5000);
	   
	   String email = properties.getProperty("email");
	   System.out.println(email);
	   
	   String password= properties.getProperty("password");
	   System.out.println(password);
	   
	   driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys(email);
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys(password);
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();
	   Thread.sleep(5000);
	   
	   
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
