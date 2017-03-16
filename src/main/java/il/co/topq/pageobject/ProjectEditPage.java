package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectEditPage extends AbstractRepositoryPage {
	private static final By ADD_COLUMN_LINK = By.xpath("//a[@href='#add-column']");
	public ProjectEditPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public NewColumnAddNameWidget clickOnAddNewColumnLink()
    {
    	bot.clickOnElementBy(ADD_COLUMN_LINK);
    	return new NewColumnAddNameWidget(driver);
    }
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void assertInPage() {
		bot.waitForElementVisibiltyBy(ADD_COLUMN_LINK);
		
	}

}
