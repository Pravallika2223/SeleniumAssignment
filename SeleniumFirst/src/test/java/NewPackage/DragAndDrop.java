package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DragAndDrop {
   
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://jqueryui.com/droppable/");
	  driver.manage().window().maximize();
	 // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }

  
  @Test
  public void f() throws InterruptedException {
	 
	 WebElement Frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
	 Thread.sleep(5000);
	 driver.switchTo().frame(Frame);
	  WebElement source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
	  WebElement target = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
	  Actions action = new Actions(driver);
	  action.dragAndDrop(source, target).build().perform();
	  String afterDragging = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
	  if(afterDragging.equals("Dropped!"))
			System.out.println("Drag successful.");
		else
			System.out.println("Drag Unsuccessful."); 
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
  driver.quit();
  }

}
