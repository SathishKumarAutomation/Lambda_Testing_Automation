package Org.LambdaTesting.Runner;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Org.LambdaTesting.Page.LambdaCapabilities;

public class LambdaRunnerClass {

 	RemoteWebDriver driver = null;
	String browserName;
	String browserVersion;
	String platform;
	String webSite;
	String expected = "https://www.lambdatest.com/integrations";

	@FindBy(css = "div.text-center.mt-25>a")
	WebElement integrationLnk;

	@Test
	public void verifyIntegrations(ITestContext context) throws InterruptedException {

		browserName = context.getCurrentXmlTest().getParameter("browserName");
		browserVersion = context.getCurrentXmlTest().getParameter("browserVersion");
		webSite = context.getCurrentXmlTest().getParameter("webSite");
		platform = context.getCurrentXmlTest().getParameter("platform");

		LambdaCapabilities capabilities = new LambdaCapabilities();
		driver = capabilities.capabilitiesSetup(browserName, browserVersion, platform);

		driver.manage().window().maximize();
		driver.get(webSite);

		WebElement integration = driver.findElement(By.cssSelector("div.text-center.mt-25>a"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", integration);

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", integration);

		Set<String> windowHandles = driver.getWindowHandles();

		System.out.println("Total Windows: " + windowHandles);
		String actualURL = driver.getCurrentUrl();

		System.out.print("Actual URL: " + actualURL);

		Assert.assertEquals(actualURL, expected);

		driver.quit();

	}
}


