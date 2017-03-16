package il.co.topq.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import il.co.topq.externalframeworks.ExcelUtils;
import il.co.topq.pageobject.CodePage;
import il.co.topq.pageobject.HomePage;
import il.co.topq.pageobject.IssuePage;
import il.co.topq.pageobject.ProjectsPage;
import il.co.topq.pageobject.SignInPage;

public class SubmitNewIssueTest extends AbstractTestCase{

	@Test(dataProvider = "parameters",enabled=false)
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
	@Test(dataProvider="newProJectParameters")
	public void AddingNewProject(String username,String password,String projectName,String projectDescription,String columnName)
	{
		String repoNameToTest = "test";
		
		SignInPage signInPage = introPage.clickOnLogInLink();
		HomePage homePage  = signInPage
				.typeToEmailTb(username)
				.typeToPasswordTb(password)
				.clickOnCommitBtn();
		CodePage repositoryPage = homePage
				.repositoriesWidget()
				.clickOnRepositoryLnk(repoNameToTest);
		ProjectsPage projectsPage = repositoryPage.clickOnProjectsTab(repoNameToTest);
		projectsPage
			.clickOnNewProjectBtn()
			.typeToNewProjectNameTb(projectName)
			.typeToNewProjectBodyTb(projectDescription)
			.clickOnSaveProjectBtn()
			.clickOnAddNewColumnLink()
			.typeToNewColumnNameTb(columnName)
			.clickOnCreateNewColumnBtn();
				
				
	}
	@Test(dataProvider="parametersForIssuesToColumns")
	public void AddingIssuesToColumn(String userName,String passWord,String projectName,String columnName)
	{
String repoNameToTest = "test";
		
		SignInPage signInPage = introPage.clickOnLogInLink();
		HomePage homePage  = signInPage
				.typeToEmailTb(userName)
				.typeToPasswordTb(passWord)
				.clickOnCommitBtn();
		CodePage repositoryPage = homePage
				.repositoriesWidget()
				.clickOnRepositoryLnk(repoNameToTest);
		ProjectsPage projectsPage = repositoryPage.clickOnProjectsTab(repoNameToTest);
	}
	
	
	@DataProvider(name = "parametersForIssuesToColumns")
	public Object[][] createDataForAddingIssuesToColumns() {
		return new Object[][] { { "sudo.chmod.a.x777@gmail.com", "sudogit777", "This is project title", "C1" } };
	}
	
	@DataProvider(name = "parameters")
	public Object[][] createData() {
		return new Object[][] { { "sudo.chmod.a.x777@gmail.com", "sudogit777", "body body" } };
	}
	
	@DataProvider(name = "newProJectParameters")
	public Object[][] createNewData() {
		return new Object[][] { { "sudo.chmod.a.x777@gmail.com", "sudogit777", "This is project title","This is project description","column columns" } };
	}
	
	@DataProvider(name = "excelparameters")
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("src//main//resources//datax.xls", "Sheet1");
		return (testObjArray);
	}

}
