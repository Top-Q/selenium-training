package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntroPage extends AbstractPageObject{
	public IntroPage() {

		getDriverInstance().get("https://github.com/");
	}
	public SignInPage clickOnLogInLink() {
		getDriverInstance().findElement(By.linkText("Sign in")).click();
		return new SignInPage();
	}
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}


}
