package il.co.topq.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.externalframeworks.ReportingaAssertion;
import il.co.topq.externalframeworks.WebDriverFactory;
import il.co.topq.pageobject.IntroPage;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTestCase {
	protected ReportDispatcher report = ReportManager.getInstance();
	protected IntroPage introPage;
	private WebDriver driver;
	protected ReportingaAssertion reportingaAssertion;

	@BeforeMethod
	public void setUp() {
		driver = WebDriverFactory.getDriver(WebDriverFactory.DriverType.CHROME);
		reportingaAssertion = new ReportingaAssertion(driver);
		driver.get("https://github.com/");
		introPage = new IntroPage(driver);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
