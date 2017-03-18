package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCardsModule extends AbstractRepositoryPage {
    private final By EXIT_BTN = By.xpath("//h4[text()='Add cards']/../button[contains(@class,'js-hide-project-menu')]");

    public AddCardsModule(WebDriver driver) {
        super(driver);
    }

    public AddCardsModule dragIssueDropToColumn(String issueName, String ColumnName) {
        By requiredColumn = By.xpath("//div//span[@class='js-project-column-name' and contains(text(),'" + ColumnName + "')]/../../../div[contains(@class, 'card-drag-container')]");
        By requiredIssue = By.xpath("//div//a[contains(text(),'" + issueName + "')]/../..");
        bot.dragFromAndDropTo(requiredIssue, requiredColumn);
        return this;
    }

    public ProjectEditPage clickOnExitFromAddCardsBtn() {
        bot.clickOnElementBy(EXIT_BTN);
        return new ProjectEditPage(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        // TODO Auto-generated method stub
    }
}
