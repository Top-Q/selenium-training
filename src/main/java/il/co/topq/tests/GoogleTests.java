package il.co.topq.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTests {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testSearchInGoogle() throws InterruptedException {
		driver.get("http://www.google.com");
		WebElement searchTb = driver.findElement(By.name("q"));
		searchTb.sendKeys("Cheese");
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(3000);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
