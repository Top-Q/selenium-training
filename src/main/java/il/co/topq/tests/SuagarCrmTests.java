package il.co.topq.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuagarCrmTests {
    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchInGoogle() throws InterruptedException {
        driver.get("https://github.com/");
        driver.findElement(By.linkText("Sign in")).click();
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.name("commit")));
        driver.findElement(By.name("login")).sendKeys("sudo.chmod.a.x777@gmail.com");
        driver.findElement(By.name("password")).sendKeys("sudogit777");
        driver.findElement(By.name("commit")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mini-repo-list-item")));
        driver.findElement(By.className("mini-repo-list-item")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/testingGunit/test/issues']")));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/testingGunit/test/issues']"))));
        driver.findElement(By.xpath("//a[@href='/testingGunit/test/issues']")).click();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/testingGunit/test/issues']")));
        driver.findElement(By.xpath("//div[@class='subnav']/a[contains(text(),'New issue')]")).click();

//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/testingGunit/test/issues/new']")));
//		element.click();
        //driver.findElement(By.xpath("//a[@href='/testingGunit/test/issues/new']")).click();
        driver.findElement(By.id("issue_title")).sendKeys("isssue need a tissue");
        driver.findElement(By.id("issue_body")).sendKeys("you have a bug find it");
        //driver.findElement(By.linkText("Submit new issue")).click();
        driver.findElement(By.xpath("//div[@class='form-actions']/button[contains(text(),'Submit new issue')]")).click();
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
