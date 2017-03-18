package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuePage extends AbstractRepositoryPage {
    private static final By ISSUE_TITLE_LBL = By.xpath("//span[@class='js-issue-title']");
    private static final By LABELS_ASSIGN_BTN = By.xpath("//button[text()[contains(.,'Labels')]]");
    private static final By ASSIGNEES_ASSIGN_BTN = By.xpath("//button[text()[contains(.,'Assignees')]]");
    private static final By MILESTONE_ASSIGN_BTN = By.xpath("//button[text()[contains(.,'Milestone')]]");

    public IssuePage(WebDriver driver) {
        super(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(ISSUE_TITLE_LBL);
    }

    public String getIssueTitleLbl() {
        return bot.getTextFromElementBy(ISSUE_TITLE_LBL);
    }

    public AssignAssigneesToIssueWidget clickOnAssingeesAssignBTN() {
        bot.clickOnElementBy(ASSIGNEES_ASSIGN_BTN);
        return new AssignAssigneesToIssueWidget(driver);
    }

    public AssignlabelsToIssueWidget clickOnLabelsAssignBTN() {
        bot.clickOnElementBy(LABELS_ASSIGN_BTN);
        return new AssignlabelsToIssueWidget(driver);
    }

    public AssignMileStoneToIssueWidget clickOnMileStoneAssignBTN() {
        bot.clickOnElementBy(MILESTONE_ASSIGN_BTN);
        return new AssignMileStoneToIssueWidget(driver);
    }
}
