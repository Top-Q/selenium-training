package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourRepositoriesWidget extends AbstractPageObject {

	public YourRepositoriesWidget(WebDriver driver) {
		super(driver);
	}

	@Override
	void assertErrorMessage(String messageText) {

	}

	@Override
	protected void assertInPage() {

	}
	
	public CodePage clickOnRepositoryLnk(String repoName){
		bot.clickOnElementBy(By.className(repoName));
		return new CodePage(driver);
	}
	

}
