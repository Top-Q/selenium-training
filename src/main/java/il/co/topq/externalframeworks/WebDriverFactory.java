package il.co.topq.externalframeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public enum DriverType {
        CHROME, FIREFOX, IE11
    }

    public static WebDriver getDriver(DriverType type) {
        WebDriver driver = null;
        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
