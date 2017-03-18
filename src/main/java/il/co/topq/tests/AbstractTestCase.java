package il.co.topq.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import il.co.topq.externalframeworks.WebDriverFactory;
import il.co.topq.pageobject.IntroPage;

public abstract class AbstractTestCase {
    protected IntroPage introPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(WebDriverFactory.DriverType.CHROME);
        introPage = new IntroPage(driver);
        driver.get("https://github.com/");
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
