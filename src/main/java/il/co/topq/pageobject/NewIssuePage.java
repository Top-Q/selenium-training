package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewIssuePage extends AbstractRepositoryPage {
    private static final By ISSUE_TITLE_TB = By.id("issue_title");
    private static final By ISSUE_BODY_TB = By.id("issue_body");
    private static final By SUBMIT_BTN = By.xpath("//div[@class='form-actions']/button[contains(text(),'Submit new issue')]");

    public NewIssuePage(WebDriver driver) {
        super(driver);
    }

    public NewIssuePage typeToNewIssueTitleTb(String title) {
        bot.typeToElementBy(ISSUE_TITLE_TB, title);
        return this;
    }

    public NewIssuePage typeToNewIssueBodyTb(String body) {
        bot.typeToElementBy(ISSUE_BODY_TB, body);
        return this;
    }

    public IssuePage clickOnSubmitNewIssueBtn() {
        bot.clickOnElementBy(SUBMIT_BTN);
        return new IssuePage(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(SUBMIT_BTN);
    }
}
