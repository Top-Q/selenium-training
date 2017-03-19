package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCardsModule extends AbstractRepositoryPage {
    private static final By EXIT_BTN = By.xpath("//h4[text()='Add cards']/../button[contains(@class,'js-hide-project-menu')]");

    public AddCardsModule(WebDriver driver) {
        super(driver);
    }

    public ProjectEditPage clickOnExitFromAddCardsBtn() {
        bot.clickOnElementBy(EXIT_BTN);
        return new ProjectEditPage(driver);
    }
    
    public AddCardIssueModule getIssue(String IssueName)
    {
    	By by = By.xpath("//div//a[contains(text(),'" + IssueName + "')]/../..");
    	return new AddCardIssueModule(driver, by);
    }
    
    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(EXIT_BTN);
    }
}
