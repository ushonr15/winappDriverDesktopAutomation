package cucumberOptions;

import pageStepdefImpl.PageObjectManger;

public class TestContextSetup {
	public TestBase testBase;
	public PageObjectManger pageObjectManager;

	public TestContextSetup() {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManger(testBase.WindowsDriverManager());
	}
}
