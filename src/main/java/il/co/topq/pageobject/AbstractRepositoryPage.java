package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractRepositoryPage extends AbstractGitHubPage {
	
	private final static By ISSUES_MENU_ITM_BY = By.xpath("//a[@href='/testingGunit/test/issues']");
	private final static By CODE_MENU_ITM_BY = By.xpath("//a[@href='/testingGunit/test/']");
	public AbstractRepositoryPage(WebDriver driver) {
		super(driver);
	}
	
	public IssuesPage clickOnIssues() {
		bot.clickOnElementBy(ISSUES_MENU_ITM_BY);
		return new IssuesPage(driver);
	}
	
	public CodePage clickOnCode() {
		bot.clickOnElementBy(CODE_MENU_ITM_BY);
		return new CodePage(driver);
	}

	

}
