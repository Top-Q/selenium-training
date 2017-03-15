package il.co.topq.externalframeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionBot {
	
	private final WebDriver driver;
	private final WebDriverWait wait;

	public ActionBot(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public ActionBot clickOnElementBy(By by){
		driver.findElement(by).click();
		return this;
	}
	
	public ActionBot typeToElementBy(By by, String text){
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(text);
		return this;
	}

	public void waitForElementVisibiltyBy(By by) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	public String getTextFromElementBy(By by)  {
		return driver.findElement(by).getText();
	}
	
	
}
