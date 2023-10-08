package stepDef;

import cucumberOptions.TestContextSetup;
import io.cucumber.java.en.Given;
import pageStepdefImpl.CalculatorMainPage;

public class CalculatorStepdef {
    TestContextSetup testContextSetup;

    public CalculatorStepdef(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I set calculator type {string}")
    public void i_set_cal_type(String type) {
        CalculatorMainPage calculatorMainPageObj = testContextSetup.pageObjectManager.getCalculatorMainPageObj();
        calculatorMainPageObj.setCalculatorMode(type);
    }

}
