package pageStepdefImpl;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class PageObjectManger {
	public WindowsDriver<WebElement> autDriver;

	public PageObjectManger(WindowsDriver<WebElement> autDriver) {
		this.autDriver = autDriver;
	}

}
