package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrokenLinks {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.zlti.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  @Test
  public void f() throws MalformedURLException, IOException {
	  
	 // driver.findElements(By.tagName(“a”)).size();
	/*  driver.findElements(By.tagName("a")).size();
	  System.out.println("no of links broken are : " + driver.findElements(By.tagName("a")).size() ); */
	//  driver.findElements(By.tagName("a"));
	  
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println("links are : "+ '\n' + links);
	  Iterator<WebElement> it = links.iterator();
	 String url = it.next().getAttribute("href");
/*	 if(url == null || url.isEmpty()){
		 System.out.println("URL is either not configured for anchor tag or it is empty");
		// continue;
		 }
	 
	 if(!url.startsWith(driver.getCurrentUrl())){
		 System.out.println("URL belongs to another domain, skipping it.");
		// continue;
		 }  */ 
	 HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
	 huc.connect();
	 
	int respCode = huc.getResponseCode();
	System.out.println("response code is : "+ respCode);
	if(respCode >= 400){
		System.out.println(url+" is a broken link");
		}
		else{
		System.out.println(url+" is a valid link");
		}
	 
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
