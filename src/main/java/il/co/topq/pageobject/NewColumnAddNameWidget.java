package il.co.topq.pageobject;

import org.apache.poi.ss.formula.functions.Column;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewColumnAddNameWidget extends AbstractRepositoryPage {
    public static final By COLUMN_TITLE_TB = By.xpath("//div[@class='facebox-popup']//*[@id='project_column_name_']");
    public static final By CREATE_COLUMN_BTN = By.xpath("//div[@class='facebox-popup']//*[contains(text(),'Create column')]");

    public NewColumnAddNameWidget(WebDriver driver) {
        super(driver);
    }

    public NewColumnAddNameWidget typeToNewColumnNameTb(String text) {
        bot.typeToElementBy(COLUMN_TITLE_TB, text);
        return this;
    }

    public ProjectEditPage clickOnCreateNewColumnBtn() {
        bot.clickOnElementBy(CREATE_COLUMN_BTN);
        return new ProjectEditPage(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(CREATE_COLUMN_BTN);
    }
}
