package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntroPage extends AbstractPageObject{

	public IntroPage(WebDriver driver) {
		super(driver);
		driver.get("https://github.com/");
	}
	public SignInPage clickOnLogInLink() {
		driver.findElement(By.linkText("Sign in")).click();
		return new SignInPage(driver);
	}


}
