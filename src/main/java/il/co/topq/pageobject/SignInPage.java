package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPageObject {
    private static final By LOGIN_TB = By.name("login");
    private static final By PASSWORD_TB = By.name("password");
    private static final By LOGIN_BTN = By.name("commit");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage typeToEmailTb(String email) {
        bot.typeToElementBy(LOGIN_TB, email);
        return this;
    }

    public SignInPage typeToPasswordTb(String password) {
        bot.typeToElementBy(PASSWORD_TB, password);
        return this;
    }

    public HomePage clickOnCommitBtn() {
        bot.clickOnElementBy(LOGIN_BTN);
        return new HomePage(driver);
    }

    @Override
    void assertErrorMessage(String messageText) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void assertInPage() {
        bot.waitForElementVisibiltyBy(LOGIN_TB);
    }
}
