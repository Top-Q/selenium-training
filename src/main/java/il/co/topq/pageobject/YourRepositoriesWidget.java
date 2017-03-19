package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourRepositoriesWidget extends AbstractPageObject {
	private static final By NEW_REPO_BTN = By.cssSelector("a[class='btn btn-sm btn-primary']");
	
    public YourRepositoriesWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
    }

    @Override
    protected void assertInPage() {
    	bot.waitForElementVisibiltyBy(NEW_REPO_BTN);
    	
    }

    public CodePage clickOnRepositoryLink(String repoName) {
        bot.clickOnElementBy(By.xpath("//a[@href='/testingGunit/" + repoName + "']"));
        return new CodePage(driver);
    }
}
