package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractRepositoryPage extends AbstractGitHubPage {
	
	public AbstractRepositoryPage(WebDriver driver) {
		super(driver);
	}
	
	public IssuesPage clickOnIssuesTab(String repoName) {
		bot.clickOnElementBy(By.xpath("//a[@href='/testingGunit/" + repoName + "/issues']"));
		return new IssuesPage(driver);
	}
	
	public CodePage clickOnCode(String repoName) {
		bot.clickOnElementBy(By.xpath("//a[@href='/testingGunit/" + repoName + "']"));
		return new CodePage(driver);
	}
	public ProjectsPage clickOnProjects(String repoName)
	{
		bot.clickOnElementBy(By.xpath("//a[@href='/testingGunit/" + repoName + "/projects']"));
		return new ProjectsPage(driver);
	}

	

}
