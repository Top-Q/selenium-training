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
    	try{
    		report.startLevel("entering email cridentials");
	        bot.typeToElementBy(LOGIN_TB, email);
	        report.log("Wrote email to email field");
	        return this;
    	}
    	finally{
    		report.endLevel();
    	}
    	

    }

    public SignInPage typeToPasswordTb(String password) {
    	try{
    		report.startLevel("entering password cridentials");
    		bot.typeToElementBy(PASSWORD_TB, password);
    		report.log("Wrote password to password field");
    		return this;
    	}
    	finally{
    		report.endLevel();
    	}
    }

    public HomePage clickOnCommitBtn() {
    	try{
    	report.startLevel("clicking on Commit button");
        bot.clickOnElementBy(LOGIN_BTN);
        report.log("clicked the commit button ");
        return new HomePage(driver);
    	}finally
    	{
    		report.endLevel();
    	}
    
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
