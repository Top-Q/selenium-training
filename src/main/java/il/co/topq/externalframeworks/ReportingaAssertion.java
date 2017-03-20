package il.co.topq.externalframeworks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class ReportingaAssertion extends Assertion {
	private WebDriver driver;
	private ReportDispatcher report = ReportManager.getInstance();
	public ReportingaAssertion(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		report.addImage(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), ex.getMessage());
		

	}

}
