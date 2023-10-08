package stepDef;

import cucumberOptions.GenericUtils;
import cucumberOptions.TestBase;
import cucumberOptions.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Before
    public void BeforeScenarios() {

        System.out.println("Before scenario");
    }


    @After
    public void AfterScenario() {
        if (!(TestBase.aut_Driver == null)) {
            TestBase.aut_Driver.quit();
            //To get new driver for next test, made it to null
            TestBase.aut_Driver = null;
        }
        GenericUtils.killAUT();
    }

    @AfterStep
    public void AddScreenShot(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) TestBase.aut_Driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
