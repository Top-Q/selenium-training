package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends AbstractRepositoryPage {

	private static final By NEW_PROJECT_BTN=By.xpath("//a[contains(text(),'New Project')]");
	public ProjectsPage(WebDriver driver) {
		super(driver);		
		// TODO Auto-generated constructor stub
	}
	 public NewProjectPage clickOnNewProjectBtn()
	  {
	    	bot.clickOnElementBy(NEW_PROJECT_BTN);
	    	return new NewProjectPage(driver);
	  }
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void assertInPage() {
		bot.waitForElementVisibiltyBy(NEW_PROJECT_BTN);
		
	}

}
