package tasts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase {
	public static WebDriver testBaseDriver;
	String URL="https://demo.nopcommerce.com/";

	@BeforeSuite
	@Parameters({"browser"})
	public void startDrier(@Optional("Chrome") String browserName) 

	{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			testBaseDriver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			testBaseDriver = new FirefoxDriver();
		}
		//System.setProperty("webdriver.chrome.driver", value)

		testBaseDriver.manage().window().maximize();
		testBaseDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		testBaseDriver.navigate().to(URL);
		
	}

	@AfterSuite
	public void stopDriver() 
	{
		//testBaseDriver.quit();
	}

	//Take screenshots when TC Fail and add to Screenshots folder
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {

			System.err.println("Failed");
			System.err.println("Taking Screenshot...");
			//Helper.captureScreenshot(testBaseDriver, result.getName());
			Helper.captureScreenshot(testBaseDriver, result.getName());
		}
	}


}
