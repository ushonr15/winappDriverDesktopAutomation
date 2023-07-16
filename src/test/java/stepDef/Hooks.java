package stepDef;

import cucumberOptions.GenericUtils;
import cucumberOptions.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Before
	public void BeforeScenarios() {
		
	}
	
	
	@After
	public void AfterScenario() {
	
	}
	
	@AfterStep
	public void AddScreenShot(Scenario scenario) {
		if(scenario.isFailed()) {
			
			
		}
	}
}
