package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CodePage extends AbstractRepositoryPage {
	private static final By CLONE_DOWNLOAD_BTN = By.cssSelector("button.btn.btn-sm.btn-primary");
	
    public CodePage(WebDriver driver) {
        super(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(CLONE_DOWNLOAD_BTN);
    }
}
