package Org.LambdaTesting.Page;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaCapabilities {

	String userName = "r.sathishkumar1909";
	String AccessToken = "Awri5BhcSaDzR52CXV2mnfOfAmg4Xyqe2vO7fPNYQ1igFrCK5t";
	String gridURL = "@hub.lambdatest.com/wd/hub";
	RemoteWebDriver driver=null;

	public RemoteWebDriver capabilitiesSetup(String browser, String version, String platform) {

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName(platform);
		browserOptions.setBrowserVersion(version);
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("project", "LamTestExecution");
		ltOptions.put("w3c", true);
		ltOptions.put("video", true);
		ltOptions.put("browserName", browser);
		ltOptions.put("network", true);
		ltOptions.put("build", "Test");
		ltOptions.put("console", true);
		ltOptions.put("visual", true);
		ltOptions.put("terminal", true);
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("plugin", "java-java");
		browserOptions.setCapability("LT:Options", ltOptions);

		try {
			driver = new RemoteWebDriver(new URL("https://"+userName+":"+AccessToken+gridURL), browserOptions);		
			}
		catch(MalformedURLException e) {
			System.out.println("Invalid URL");
		}

		return driver;
	}
}