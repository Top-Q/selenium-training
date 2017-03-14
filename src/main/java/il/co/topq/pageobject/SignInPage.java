package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPageObject{

	public SignInPage() {
		// TODO Auto-generated constructor stub
	}
	public void typeToEmail(String email)
	{
		getDriverInstance().findElement(By.name("login")).sendKeys(email);

	}
	public void typeToPassowrd(String password)
	{
		getDriverInstance().findElement(By.name("password")).sendKeys(password);
	}
	public HomePage clickOnCommitButton()
	{
		getDriverInstance().findElement(By.name("commit")).click();
		return new HomePage();
	}
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}
}
