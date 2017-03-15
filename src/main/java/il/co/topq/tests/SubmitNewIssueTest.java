package il.co.topq.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import il.co.topq.externalframeworks.ExcelUtils;
import il.co.topq.pageobject.CodePage;
import il.co.topq.pageobject.HomePage;
import il.co.topq.pageobject.IssuePage;
import il.co.topq.pageobject.SignInPage;

public class SubmitNewIssueTest extends AbstractTestCase{

	@Test(dataProvider = "parameters")
	public void fromStartToEnd(String username, String password, String body) {
		String repoNameToTest = "test";
		
		SignInPage signInPage = introPage.clickOnLogInLink();
		HomePage homePage  = signInPage
				.typeToEmailTb(username)
				.typeToPasswordTb(password)
				.clickOnCommitBtn();
		
		CodePage repositoryPage = homePage
				.repositoriesWidget()
				.clickOnRepositoryLnk(repoNameToTest);
		
		final String title = "someIssue" + System.currentTimeMillis();
		
		 IssuePage issuePage = repositoryPage
		 		.clickOnIssuesTab(repoNameToTest)
				.clickOnNewIssueBtn()
				.typeToNewIssueTitleTb(title)
				.typeToNewIssueBodyTb(body)
				.clickOnSubmitNewIssueBtn();
		 
		 String resultTitle = issuePage.getIssueTitleLbl();
		 boolean strCompResult = title.equals(resultTitle);
		 Assert.assertTrue(strCompResult);
		 
		 issuePage
		 		.clickOnAssingeesAssignBTN()
		 		.chooseLabelsFromListByName("testingGunit")
		 		.clickOnExitSvg()
		 		.clickOnLabelsAssignBTN()
		 		.chooseLabelsFromListByName("bug")
		 		.clickOnExitSvg()
		 		.clickOnMileStoneAssignBTN()
		 		.chooseMileStoneFromListByNameSpan("MS1.0.0");
		 		
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
