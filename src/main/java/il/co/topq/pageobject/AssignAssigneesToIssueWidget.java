package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignAssigneesToIssueWidget extends AbstractPageObject {
    private static final By EXIT_SVG = By.xpath("//div[@class='select-menu-modal']//span[text()='Assign up to 10 people to this issue']/../..//*[@aria-label='Close']");

    public AssignAssigneesToIssueWidget(WebDriver driver) {
        super(driver);
    }

    public AssignAssigneesToIssueWidget chooseLabelsFromListByCb(String projectName) {
        bot.clickOnElementBy(By.xpath("//div[@class='select-menu-modal']//span[contains(., '" + projectName + "')]"));
        return this;
    }

    public IssuePage clickOnExitBtn() {
        bot.clickOnElementBy(EXIT_SVG);
        return new IssuePage(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(EXIT_SVG);
    }
}
