package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage extends AbstractPageObject {

	public IssuesPage() {
		// TODO Auto-generated constructor stub
	}
    public NewIssuePage clickOnNewIssueBtn()
    {
    	getDriverInstance().findElement(By.xpath("//div[@class='subnav']/a[contains(text(),'New issue')]")).click();
    	return new NewIssuePage();
    }
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}
	
	

}
