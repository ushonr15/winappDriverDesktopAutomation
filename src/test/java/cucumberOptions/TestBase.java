package cucumberOptions;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class TestBase {

	// driver to drive Application under test, here Notepad++
	public static WindowsDriver<WebElement> aut_Driver;

	// Driver to drive desktop
	public static WindowsDriver<WebElement> desktop_Driver;

	public WindowsDriver<WebElement> WindowsDriverManager() {
		if (aut_Driver == null) {
			try {
				DesiredCapabilities aut_Capabilities = new DesiredCapabilities();
				aut_Capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
				//aut_Capabilities.setCapability("app", GenericUtils.getGlobalProperties().getProperty("autInstalledLocation"));
				aut_Driver = new WindowsDriver<WebElement>(new URL(GenericUtils.getGlobalProperties().getProperty("winAppDriverURL")), aut_Capabilities);
				aut_Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				aut_Driver.manage().window().maximize();
				DesiredCapabilities desktop_Capabilities = new DesiredCapabilities();
				desktop_Capabilities.setCapability("app", "Root");
				desktop_Driver = new WindowsDriver<WebElement>(new URL(GenericUtils.getGlobalProperties().getProperty("winAppDriverURL")), desktop_Capabilities);
				
			} catch (Exception e) {
				assertTrue("Failed to Get Notepadd++ session", false);
			}
		}
		return aut_Driver;
	}

}
