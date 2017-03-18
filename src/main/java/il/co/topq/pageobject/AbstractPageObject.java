package il.co.topq.pageobject;

import org.openqa.selenium.WebDriver;

import il.co.topq.externalframeworks.ActionBot;

public abstract class AbstractPageObject {
	protected final WebDriver driver;
	protected final ActionBot bot;
	
	public AbstractPageObject(WebDriver driver){
		this.driver = driver;
		bot = new ActionBot(driver);
		assertInPage();
	}

	abstract void assertErrorMessage(String messageText);
	protected abstract void assertInPage();
}
