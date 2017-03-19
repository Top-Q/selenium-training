package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.mobile.AddNetworkConnection;

public class ProjectEditPage extends AbstractRepositoryPage {
	private static final By ADD_COLUMN_LINK = By.xpath("//a[@href='#add-column']");
	private static final By ADD_CARDS_BTN = By.xpath("//*[contains(@data-channel,'add_cards')]/button");

	public ProjectEditPage(WebDriver driver) {
		super(driver);
	}

	public NewColumnAddNameWidget clickOnAddNewColumnLink() {
		bot.clickOnElementBy(ADD_COLUMN_LINK);
		return new NewColumnAddNameWidget(driver);
	}

	public AddCardsModule clickOnAddCardsLink() {
		bot.clickOnElementBy(ADD_CARDS_BTN);
		return new AddCardsModule(driver);
	}

	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void assertInPage() {
		bot.waitForElementPresenceBy(ADD_CARDS_BTN);
	}

	public ProjectEditPage dragIssueOnCoulumn(AddCardIssueModule addCardIssueModule, String columnName) {
		By requiredColumn = By.xpath("//div//span[@class='js-project-column-name' and contains(text(),'" + columnName
				+ "')]/../../../div[contains(@class, 'card-drag-container')]");
		bot.dragFromAndDropTo(addCardIssueModule.getIssueLocator(), requiredColumn);
		return this;
	}
}
