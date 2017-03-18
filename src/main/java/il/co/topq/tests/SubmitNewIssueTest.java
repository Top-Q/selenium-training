package il.co.topq.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import il.co.topq.externalframeworks.ExcelUtils;
import il.co.topq.pageobject.AddCardsModule;
import il.co.topq.pageobject.*;

public class SubmitNewIssueTest extends AbstractTestCase {
    @DataProvider(name = "parametersForIssuesToColumns")
    public Object[][] createDataForAddingIssuesToColumns() {
        return new Object[][]{{"sudo.chmod.a.x777@gmail.com", "sudogit777", "This is project title", "C1", "tuj"}};
    }

    @DataProvider(name = "parameters")
    public Object[][] createData() {
        return new Object[][]{{"sudo.chmod.a.x777@gmail.com", "sudogit777"}};
    }

    @DataProvider(name = "newProJectParameters")
    public Object[][] createNewData() {
        return new Object[][]{{"sudo.chmod.a.x777@gmail.com", "sudogit777", "This is project title", "This is project description", "column columns"}};
    }

    @DataProvider(name = "excelparameters")
    public Object[][] Authentication() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src//main//resources//datax.xls", "Sheet1");
        return (testObjArray);
    }

    @Test(dataProvider = "parameters", enabled = true)
    public void fromStartToEnd(String username, String password) {
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
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
                .typeToNewIssueBodyTb("body body")
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

    @Test(dataProvider = "newProJectParameters", enabled = true)
    public void AddingNewProject(String username, String password, String projectName, String projectDescription, String columnName) {
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
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

    @Test(dataProvider = "parametersForIssuesToColumns", enabled = true)
    public void AddingIssuesToColumn(String userName, String passWord, String projectName, String columnName, String issueName) {
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
                .typeToEmailTb(userName)
                .typeToPasswordTb(passWord)
                .clickOnCommitBtn();
        CodePage repositoryPage = homePage
                .repositoriesWidget()
                .clickOnRepositoryLnk(repoNameToTest);
        ProjectsPage projectsPage = repositoryPage.clickOnProjectsTab(repoNameToTest);
        AddCardsModule cardModule = projectsPage
                .clickOnProjectLink(projectName)
                .clickOnAddCardsLink()
                .dragIssueDropToColumn(issueName, columnName);
        cardModule.clickOnExitFromAddCardsBtn();
    }

    @Test(dataProvider = "parameters", enabled = true)
    public void fromStartToCreationOfMilestone(String username, String password) {
        String repoNameToTest = "test";

        SignInPage signInPage = introPage.clickOnLogInLink();
        HomePage homePage = signInPage
                .typeToEmailTb(username)
                .typeToPasswordTb(password)
                .clickOnCommitBtn();

        NewMilestonePage newMilestonePage = homePage
                .repositoriesWidget()
                .clickOnRepositoryLnk(repoNameToTest)
                .clickOnIssuesTab("test")
                .clickOnMilestonesBtn()
                .clickNewMilestoneBtn();

        String milestoneTitle = "Some Milestone" + System.currentTimeMillis();

        newMilestonePage
                .typeToMilestoneTitleTb(milestoneTitle)
                .typeToMilestoneDescriptionTa("Some Milestone")
                .setDateFromCalenderTb("1 Apr 2017")
                .clickCreateMilestoneBtn();
    }
}
