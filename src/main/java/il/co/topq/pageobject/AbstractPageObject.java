package il.co.topq.pageobject;

import java.nio.file.NoSuchFileException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.externalframeworks.ActionBot;

public abstract class AbstractPageObject {
	protected final WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();
	protected final ActionBot bot;

	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
		bot = new ActionBot(driver);
		waitForScreenToLoad();
	}

	void waitForScreenToLoad() {
		String className = this.getClass().getSimpleName();
		try {
			report.step("assert " + className);
			assertInPage();
		} finally {
			takeAScreenshot(className);
		}
	}

	protected void takeAScreenshot(String description) {
		try {
			report.addImage(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), description);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	abstract void assertErrorMessage(String messageText);

	protected abstract void assertInPage();
}
