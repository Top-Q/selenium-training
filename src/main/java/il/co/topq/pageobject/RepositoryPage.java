package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryPage extends AbstractPageObject{

	public RepositoryPage() {
		// TODO Auto-generated constructor stub
	}
   public IssuesPage clickOnIssues()
   {
	   getDriverInstance().findElement(By.xpath("//a[@href='/testingGunit/test/issues']")).click();
	   return new IssuesPage();
   }
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}

}
