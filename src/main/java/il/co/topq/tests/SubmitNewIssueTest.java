package il.co.topq.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import il.co.topq.externalframeworks.ExcelUtils;
import il.co.topq.pageobject.CodePage;
import il.co.topq.pageobject.HomePage;
import il.co.topq.pageobject.SignInPage;

public class SubmitNewIssueTest extends AbstractTestCase{

	@Test(dataProvider = "excelparameters")
	public void fromStartToEnd(String username, String password, String body) {
		SignInPage signInPage = introPage.clickOnLogInLink();
		HomePage homePage  = signInPage
				.typeToEmailTb(username)
				.typeToPasswordTb(password)
				.clickOnCommitButton();
		
		CodePage repositoryPage = homePage
				.repositoriesWidget()
				.clickOnRepositoryLnk("test");
		
		final String title = "someIssue" + System.currentTimeMillis();
		
		 repositoryPage
		 		.clickOnIssues()
				.clickOnNewIssueBtn()
				.typeToNewIssueTitle(title)
				.typeToNewIssueBody(body)
				.clickOnSubmitNewIssue();
	}
	
	
	
	@DataProvider(name = "parameters")
	public Object[][] createData() {
		return new Object[][] { { "sudo.chmod.a.x777@gmail.com", "sudogit777", "body body" } };
	}
	
	@DataProvider(name = "excelparameters")
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("src//main//resources//datax.xls", "Sheet1");
		return (testObjArray);
	}

}
