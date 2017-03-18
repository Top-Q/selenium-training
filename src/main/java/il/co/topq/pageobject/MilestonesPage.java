package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestonesPage extends AbstractRepositoryPage {
    private static final By NEW_MILESTONE_BTN = By.xpath("//a[text()='New milestone']");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(NEW_MILESTONE_BTN);
    }

    public NewMilestonePage clickNewMilestoneBtn() {
        bot.clickOnElementBy(NEW_MILESTONE_BTN);
        return new NewMilestonePage(driver);
    }
}
