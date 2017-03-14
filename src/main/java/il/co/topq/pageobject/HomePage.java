package il.co.topq.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPageObject{
    
	public HomePage() {
	}
    public RepositoryPage clickOnRepostoryList()
    {
    	WebDriver driver=getDriverInstance();
    	driver.findElement(By.className("mini-repo-list-item")).click();
    	return new RepositoryPage();
    }
	@Override
	void assertErrorMessage(String messageText) {
		// TODO Auto-generated method stub
		
	}

}
