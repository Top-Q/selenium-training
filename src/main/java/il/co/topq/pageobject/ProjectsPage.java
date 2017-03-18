package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends AbstractRepositoryPage {
    private static final By NEW_PROJECT_BTN = By.xpath("//a[contains(text(),'New Project')]");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage clickOnNewProjectBtn() {
        bot.clickOnElementBy(NEW_PROJECT_BTN);
        return new NewProjectPage(driver);
    }

    public ProjectEditPage clickOnProjectLink(String projectName) {
        By projectLink = By.xpath("//a[contains(text(),'" + projectName + "')]");
        bot.clickOnElementBy(projectLink);
        return new ProjectEditPage(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(NEW_PROJECT_BTN);
    }
}
