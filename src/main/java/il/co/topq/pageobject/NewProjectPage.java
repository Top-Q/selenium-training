package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage extends AbstractRepositoryPage{
	private static final By PROJECT_NAME_TB=By.id("project_name");
	private static final By PROJECT_BODY_TB=By.id("project_body");
	private static final By SAVE_PROJECT_BTN = By.xpath("//button[contains(text(),'Save project')]");
	public NewProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public NewProjectPage typeToNewProjectNameTb(String projectName)
	{
		bot.typeToElementBy(PROJECT_NAME_TB, projectName);
		return this;
	}
	public NewProjectPage typeToNewProjectBodyTb(String body)
	{
		bot.typeToElementBy(PROJECT_BODY_TB, body);
		return this;
	}
	public ProjectEditPage clickOnSaveProjectBtn()
	{
		bot.clickOnElementBy(SAVE_PROJECT_BTN);
		return new ProjectEditPage(driver);

	}

	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void assertInPage() {
		bot.waitForElementVisibiltyBy(SAVE_PROJECT_BTN);

	}

}
