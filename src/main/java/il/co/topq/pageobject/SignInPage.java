package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPageObject{

	private static final By LOGIN_TB_BY = By.name("login");
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	public SignInPage typeToEmailTb(String email)
	{
		bot.typeToElementBy(LOGIN_TB_BY, email);
		return this;
	}
	public SignInPage typeToPasswordTb(String password)
	{
		driver.findElement(By.name("password")).sendKeys(password);
		return this;
	}
	public HomePage clickOnCommitButton()
	{
		driver.findElement(By.name("commit")).click();
		return new HomePage(driver);
	}
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void assertInPage() {
		bot.waitForElementVisibiltyBy(LOGIN_TB_BY);
	}
}
