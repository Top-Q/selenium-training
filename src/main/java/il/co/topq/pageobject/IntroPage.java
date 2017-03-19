package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntroPage extends AbstractPageObject {
	private static final By SIGN_IN_LINK = By.cssSelector("a[href='/login']");

	public IntroPage(WebDriver driver) {
		super(driver);
	}

	public SignInPage clickOnLogInLink() {
		report.log("try clicking on log in link");
		bot.clickOnElementBy(SIGN_IN_LINK);
		return new SignInPage(driver);
	}

	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void assertInPage() {
		bot.waitForElementPresenceBy(SIGN_IN_LINK);
	}
}
