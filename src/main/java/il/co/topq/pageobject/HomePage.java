package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractGitHubPage {
	private static final By READ_GUIDE_BTN = By.cssSelector("a[href='https://guides.github.com/activities/hello-world/']");
	
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public YourRepositoriesWidget repositoriesWidget() {
        return new YourRepositoriesWidget(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
      bot.waitForElementVisibiltyBy(READ_GUIDE_BTN);
    }
}
