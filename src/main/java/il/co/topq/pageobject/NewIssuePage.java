package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewIssuePage extends AbstractPageObject{

	public NewIssuePage() {

		// TODO Auto-generated constructor stub
	}
    public void typeToNewIssueTitle(String title)
    {
    	getDriverInstance().findElement(By.id("issue_title")).sendKeys(title);
    }
    public void typeToNewIssueBody(String body)
    {
    	getDriverInstance().findElement(By.id("issue_body")).sendKeys(body);
    }
    public void clickOnSubmitNewIssue()
    {
    	getDriverInstance().findElement(By.xpath("//div[@class='form-actions']/button[contains(text(),'Submit new issue')]")).click();
    }
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}
	

}
