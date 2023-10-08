package pageStepdefImpl;

import cucumberOptions.TestBase;
import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class PageObjectManger {
    public WindowsDriver<WebElement> autDriver;

    public PageObjectManger(WindowsDriver<WebElement> autDriver) {
        this.autDriver = autDriver;
    }

    public CalculatorMainPage calculatorMainPageObj;

    public CalculatorMainPage getCalculatorMainPageObj() {
        this.autDriver = TestBase.aut_Driver;
        calculatorMainPageObj = new CalculatorMainPage(autDriver);
        return calculatorMainPageObj;
    }
}
