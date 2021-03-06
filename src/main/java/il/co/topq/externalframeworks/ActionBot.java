package il.co.topq.externalframeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class ActionBot {
	protected ReportDispatcher report = ReportManager.getInstance();
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ActionBot(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public ActionBot clickOnElementBy(By by) {
        driver.findElement(by).click();
        report.log("clicked");
        return this;
    }

    public ActionBot typeToElementBy(By by, String text) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
        report.log("typed"+text+" to element");
        return this;
    }

    public void waitForElementVisibiltyBy(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForElementPresenceBy(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getTextFromElementBy(By by) {	 
        String text = driver.findElement(by).getText();
        report.log("retrieved text from element");
        return text;
       
    }

    public ActionBot dragFromAndDropTo(By from, By to) {
        WebElement fromElement = driver.findElement(from);
        WebElement toElement = driver.findElement(to);
        (new Actions(driver)).dragAndDrop(fromElement, toElement).perform();
        try {
			ExternalUtils.dragAndDropElement(fromElement, toElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return this;
    }

    public ActionBot executeJavaScript(String javaScriptCode) {
        ((JavascriptExecutor) driver).executeScript(javaScriptCode, "");
        return this;
    }
    
    public ActionBot setAttributeValueBy(String xpathForFindingElement, String attributeName, String attributeValue) {
        String javaScriptCodeForSettingAttribute = "function getElementByXpath(path) {"
                + "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;"
                + "}"
                + "getElementByXpath(\"" + xpathForFindingElement + "\").setAttribute(\"" + attributeName + "\", \"" + attributeValue + "\");";

        executeJavaScript(javaScriptCodeForSettingAttribute);
        return this;
    }

    public String getAttributeValueBy(By by, String attributeName) {
        return driver.findElement(by).getAttribute(attributeName);
    }
}
