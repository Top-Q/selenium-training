package il.co.topq.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import il.co.topq.externalframeworks.ExcelUtils;
import il.co.topq.externalframeworks.ReportingaAssertion;
import il.co.topq.pageobject.AddCardsModule;
import il.co.topq.pageobject.*;

public class SubmitNewIssueTest extends AbstractTestCase {
    @DataProvider(name = "parametersForIssuesToColumns")
    public Object[][] createDataForAddingIssuesToColumns() {
        return new Object[][]{{"example@.com", "password", "This is project title", "column columns", "tuj"}};
    }

    @DataProvider(name = "parameters")
    public Object[][] createData() {
        return new Object[][]{{"example@.com", "password"}};
    }

    @DataProvider(name = "newProJectParameters")
    public Object[][] createNewData() {
        return new Object[][]{{"example@.com", "password", "This is project title", "This is project description", "column columns"}};
    }

    @DataProvider(name = "excelparameters")
    public Object[][] authentication() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src//main//resources//datax.xls", "Sheet1");
        return (testObjArray);
    }

    @Test(dataProvider = "parameters", enabled = true)
    public void addingNewIssue(String username, String password) {
    	
    	report.startLevel("Adding New Issue");
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
                .typeToEmailTb(username)
                .typeToPasswordTb(password)
                .clickOnCommitBtn();

        CodePage repositoryPage = homePage
                .repositoriesWidget()
                .clickOnRepositoryLink(repoNameToTest);

        final String title = "someIssue" + System.currentTimeMillis();

        IssuePage issuePage = repositoryPage
                .clickOnIssuesNavBtn(repoNameToTest)
                .clickOnNewIssueBtn()
                .typeToNewIssueTitleTb(title)
                .typeToNewIssueBodyTb("body body")
                .clickOnSubmitNewIssueBtn();

        String resultTitle = issuePage.getIssueTitleLbl();
        //boolean strCompResult = title.equals(resultTitle);
        //reportingaAssertion.assertTrue(false);
        //Assert.assertTrue(strCompResult);

        issuePage
                .clickOnAssingeesAssignBtn()
                .chooseLabelsFromListByCb("testingGunit")
                .clickOnExitBtn()
                .clickOnLabelsAssignBtn()
                .chooseLabelsFromListByCb("bug")
                .clickOnExitBtn()
                .clickOnMileStoneAssignBtn()
                .chooseMileStoneFromListByRd("MS1.0.0");
        report.endLevel();
    }

    @Test(dataProvider = "newProJectParameters", enabled = false)
    public void addingNewProject(String username, String password, String projectName, String projectDescription, String columnName) {
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
                .typeToEmailTb(username)
                .typeToPasswordTb(password)
                .clickOnCommitBtn();
        CodePage repositoryPage = homePage
                .repositoriesWidget()
                .clickOnRepositoryLink(repoNameToTest);

        ProjectsPage projectsPage = repositoryPage.clickOnProjectsNavBtn(repoNameToTest);
        projectsPage
                .clickOnNewProjectBtn()
                .typeToNewProjectNameTb(projectName)
                .typeToNewProjectBodyTb(projectDescription)
                .clickOnSaveProjectBtn()
                .clickOnAddNewColumnLink()
                .typeToNewColumnNameTb(columnName)
                .clickOnCreateNewColumnBtn();
    }

    @Test(dataProvider = "parametersForIssuesToColumns", enabled = false)
    public void addingIssuesToColumn(String userName, String passWord, String projectName, String columnName, String issueName) {
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
                .typeToEmailTb(userName)
                .typeToPasswordTb(passWord)
                .clickOnCommitBtn();
        CodePage repositoryPage = homePage
                .repositoriesWidget()
                .clickOnRepositoryLink(repoNameToTest);
        ProjectEditPage projectEditPage = repositoryPage
        		.clickOnProjectsNavBtn(repoNameToTest)
        		.clickOnProjectLink(projectName);
        AddCardsModule addcardsModule =projectEditPage
        		.clickOnAddCardsLink();
        AddCardIssueModule issueModule = addcardsModule
        		.getIssue(issueName);
        
        projectEditPage.dragIssueOnCoulumn(issueModule, columnName);
        addcardsModule.clickOnExitFromAddCardsBtn();
    }
    
    @Test(dataProvider = "parameters", enabled = false)
    public void creationOfMilestone(String username, String password) {
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
                .typeToEmailTb(username)
                .typeToPasswordTb(password)
                .clickOnCommitBtn();

        NewMilestonePage newMilestonePage = homePage
                .repositoriesWidget()
                .clickOnRepositoryLink(repoNameToTest)
                .clickOnIssuesNavBtn("test")
                .clickOnMilestonesBtn()
                .clickNewMilestoneBtn();

        String milestoneTitle = "Some Milestone" + System.currentTimeMillis();

        newMilestonePage
                .typeToMilestoneTitleTb(milestoneTitle)
                .typeToMilestoneDescriptionTb("Some Milestone")
                .setDateFromCalenderTb("1 Apr 2017")
                .clickCreateMilestoneBtn();
    }
}
