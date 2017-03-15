package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntroPage extends AbstractPageObject{
	private static final By SIGN_IN_LINK = By.linkText("Sign in");
	
	
	public IntroPage(WebDriver driver) {
		super(driver);

	}
	public SignInPage clickOnLogInLink() {
		bot.clickOnElementBy(SIGN_IN_LINK);
		return new SignInPage(driver);
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
