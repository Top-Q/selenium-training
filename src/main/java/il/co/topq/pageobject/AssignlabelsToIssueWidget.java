package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignlabelsToIssueWidget extends AbstractPageObject {
    private static final By EXIT_SVG = By.xpath("//div[@class='select-menu-modal']//span[text()='Apply labels to this issue']/../..//*[@aria-label='Close']");

    public AssignlabelsToIssueWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(EXIT_SVG);
    }

    public AssignlabelsToIssueWidget chooseLabelsFromListByCb(String name) {
        bot.clickOnElementBy(By.xpath("//div[@class='select-menu-modal']//span[text()='Apply labels to this issue']/../../..//div[@data-name='" + name + "']/../../.."));
        return this;
    }

    public IssuePage clickOnExitBtn() {
        bot.clickOnElementBy(EXIT_SVG);
        return new IssuePage(driver);
    }
}
