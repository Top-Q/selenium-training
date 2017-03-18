package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignMileStoneToIssueWidget extends AbstractPageObject {
    private static final By EXIT_SVG = By.xpath("//div[@class='select-menu-modal']//span[text()='Set milestone']/../..//*[@aria-label='Close']");

    public AssignMileStoneToIssueWidget(WebDriver driver) {
        super(driver);
    }

    public AssignMileStoneToIssueWidget chooseMileStoneFromListByNameSpan(String mileStone) {
        bot.clickOnElementBy(By.xpath("//div[@class='select-menu-modal']//span[contains(., '" + mileStone + "')]/../.."));
        return this;
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
