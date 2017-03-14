package il.co.topq.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractPageObject {
    
	
    private static WebDriver driver =null;
	private static void driverConfig()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public static WebDriver getDriverInstance()
	{
		if(driver==null)
		{
			driverConfig();
		}
		return driver;
	}
	abstract void assertErrorMessage(String messageText);
}
