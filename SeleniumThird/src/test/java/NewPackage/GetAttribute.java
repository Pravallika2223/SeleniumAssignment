package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GetAttribute {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://accounts.google.com/signup");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  
  @Test
  public void f() throws InterruptedException {
    driver.findElement(By.id("firstName")).sendKeys("Shariya");
	String firstname=  driver.findElement(By.xpath("//*[@id=\"firstName\"]")).getAttribute("id");
	System.out.println("the attribute of firstname is : "+firstname); 
	Thread.sleep(1000);
	
	driver.findElement(By.id("lastName")).sendKeys("Sher");
	String lastname = driver.findElement(By.xpath("//*[@id=\"lastName\"]")).getAttribute("id");
	System.out.println("the attribute of lastname is : "+lastname);
	Thread.sleep(1000);
	
	driver.findElement(By.id("username")).sendKeys("shariyasher123");
	String username = driver.findElement(By.xpath("//*[@id=\"username\"]")).getAttribute("id");
	System.out.println("the attribute of username is : "+username);
	Thread.sleep(1000);
	
	driver.findElement(By.name("Passwd")).sendKeys("Sweety@123");
	String password = driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).getAttribute("type");
	System.out.println("the attribute of password is : "+ password);
	Thread.sleep(1000);
	
	driver.findElement(By.name("ConfirmPasswd")).sendKeys("Sweety@123");
	String cfrpassword = driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).getAttribute("aria-label");
	System.out.println("the attribute of confirm password is : "+cfrpassword);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/span")).click();
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
