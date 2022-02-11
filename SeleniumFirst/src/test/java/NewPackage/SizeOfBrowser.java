package NewPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SizeOfBrowser {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void f() throws InterruptedException {
		Dimension initial_size = driver.manage().window().getSize();
	    int height = initial_size.getHeight();
	    System.out.println("height is "+ height);
	    int width = initial_size.getWidth();
	    System.out.println("width is "+ width);
		System.out.println(driver.manage().window().getSize());
	}
	@AfterMethod
	public void afterMethod() {
		//output: (994, 718)

		driver.quit();

	}
}