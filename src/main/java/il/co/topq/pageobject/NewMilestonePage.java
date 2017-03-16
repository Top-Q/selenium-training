package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NewMilestonePage extends AbstractRepositoryPage{

	private static final By MILESTONE_TITLE_TB = By.xpath("//input[@id='milestone_title']");
	private static final By MILESTONE_DESCRIPTION_TA = By.xpath("//textarea[@id='milestone_description']");
	private static final By CREATE_MILESTONE_BTN = By.xpath("//button[text()='Create milestone']");
	private static final By TODAYS_DATE_LNK = By.xpath("//table//td[contains(@class,'today')]");
	
	public NewMilestonePage(WebDriver driver) {
		super(driver);
	}

	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void assertInPage() {
		bot.waitForElementVisibiltyBy(MILESTONE_TITLE_TB);
	}
	
	public MilestonesPage clickCreateMilestoneBtn()
	{
		bot.clickOnElementBy(CREATE_MILESTONE_BTN);
		return new MilestonesPage(driver);
	}
	
	public NewMilestonePage typeToMilestoneTitleTb(String title)
	{
		bot.typeToElementBy(MILESTONE_TITLE_TB, title);
		return this;
	}
	
	public NewMilestonePage typeToMilestoneDescriptionTa(String description)
	{
		bot.typeToElementBy(MILESTONE_DESCRIPTION_TA, description);
		return this;
	}
	
	public NewMilestonePage setDateFromCalenderTb(String attributeValue)
	{
		
		bot.setAttributeValueBy("//input[@id='milestone_due_on']", "value", attributeValue);
		return this;
	}
	
	
}
