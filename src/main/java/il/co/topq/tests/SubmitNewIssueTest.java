package il.co.topq.tests;
import org.testng.annotations.*;

import com.beust.testng.*;

import il.co.topq.externalframeworks.ExcelUtils;
import il.co.topq.pageobject.HomePage;
import il.co.topq.pageobject.IntroPage;
import il.co.topq.pageobject.IssuesPage;
import il.co.topq.pageobject.NewIssuePage;
import il.co.topq.pageobject.RepositoryPage;
import il.co.topq.pageobject.SignInPage;

public class SubmitNewIssueTest {
	private IntroPage introPage;
	private SignInPage signInPage;
	private HomePage homePage;
	private RepositoryPage repositoryPage;
	private IssuesPage issuePage;
	private NewIssuePage newIssuePage;
	@DataProvider(name = "parameters")
		public Object[][] createData() {
		return new Object[][] {{ "sudo.chmod.a.x777@gmail.com", "sudogit777" ,"Title","body body"}};
	}
	 @DataProvider(name="excelparameters")
	  public Object[][] Authentication() throws Exception{

	         Object[][] testObjArray = ExcelUtils.getTableArray("src//main//resources//datax.xls","Sheet1");
	         return (testObjArray);
	}
	@BeforeMethod
	public void setUp()
	{
		introPage=new IntroPage();
	}
	@Test(dataProvider="excelparameters")
	public void fromStartToEnd(String username,String password,String title,String body)
	{
        signInPage=introPage.clickOnLogInLink();
        signInPage.typeToEmail(username);
        signInPage.typeToPassowrd(password);
        homePage=signInPage.clickOnCommitButton();
        repositoryPage=homePage.clickOnRepostoryList();
        issuePage=repositoryPage.clickOnIssues();
        newIssuePage=issuePage.clickOnNewIssueBtn();
        newIssuePage.typeToNewIssueTitle(title);
        newIssuePage.typeToNewIssueBody(body);
        newIssuePage.clickOnSubmitNewIssue();
	}
	

}
