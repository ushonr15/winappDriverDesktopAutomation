package pageStepdefImpl;

import cucumberOptions.GenericUtils;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CalculatorMainPage {
    public WindowsDriver<WebElement> autDriver;

    public CalculatorMainPage(WindowsDriver<WebElement> autDriver) {
        this.autDriver = autDriver;
    }

    public void setCalculatorMode(String mode) {
        this.autDriver.findElementByAccessibilityId("TogglePaneButton").click();
        GenericUtils.hardWait(2);
        Actions action = new Actions(this.autDriver);
        List<WebElement> listofMode = this.autDriver.findElementsByTagName("ListItem");
        for (WebElement ele : listofMode) {
            //  System.out.println(ele.getAttribute("Name"));
            if (ele.getAttribute("Name").equals(mode)) {
                ele.click();
               // action.moveToElement(ele).click().doubleClick().build().perform();
                break;
            }

        }
    }
}
