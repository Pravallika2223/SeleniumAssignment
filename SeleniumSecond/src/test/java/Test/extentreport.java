package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentreport {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {

		htmlReporter = new ExtentHtmlReporter("extent.html");
        // create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		}
	
	 @BeforeTest
	  public void beforeTest() {
		 
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		 // driver.get("https://mvnrepository.com/");
		  driver.manage().window().maximize();
		  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	
	@Test
	public void f() throws IOException {

		ExtentTest test = extent.createTest("Repository Search", "Validating MAVEN Repository Search");
		driver.get("https://mvnrepository.com/");
		test.pass("Navigated to Repository site");
        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.pass("This case is passed");
		
	}
	
	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}

}
