package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCardIssueModule extends AbstractRepositoryPage {
	private final By ISSUE_LOCATOR;

	public AddCardIssueModule(WebDriver driver, By by) {
		super(driver);
		this.ISSUE_LOCATOR = by;
	}

	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void assertInPage() {
	}

	public By getIssueByText(String issueText) {
		return new By.ByXPath("//div//a[contains(text(),'" + issueText + "')]/../..");
	}

	public By getIssueLocator() {
		return this.ISSUE_LOCATOR;
	}
}
