package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage extends AbstractRepositoryPage {
 
	private static final By NEW_ISSUE_BTN=By.xpath("//div[@class='subnav']/a[contains(text(),'New issue')]");
	private static final By MILESTONE_BTN = By.xpath("//a[text()='Milestones']");
	
	public IssuesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public NewIssuePage clickOnNewIssueBtn()
    {
    	bot.clickOnElementBy(NEW_ISSUE_BTN);
    	return new NewIssuePage(driver);
    }
    
    
    public MilestonesPage clickOnMilestonesBtn()
    {
    	bot.clickOnElementBy(MILESTONE_BTN);
    	return new MilestonesPage(driver);
    }
    
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void assertInPage() {
		bot.waitForElementVisibiltyBy(NEW_ISSUE_BTN);
		
	}
	
	

}
