package cucumberOptions;

import java.awt.Desktop;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featureFiles", glue = "stepDef", tags = "", monochrome = true, stepNotifications = true, plugin = { "pretty",
		"html:target/cucumber.html", "json:target/cucumber.json", "junit:targget/cuckes.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:test-output/SparkReport/Spark.html",
		"rerun:target/failed_scenarios.txt" })
public class TestRunner {

	private static String formattedDate;

	@BeforeClass
	public static void BeforeExecution() {
		LocalDateTime dateObj = LocalDateTime.now();
		DateTimeFormatter formattObj = DateTimeFormatter.ofPattern("d-MMM-YY-HH-mm");
		formattedDate = dateObj.format(formattObj);

	}

	@AfterClass
	public static void AfterExecution() {
		Desktop desk = Desktop.getDesktop();
		try {
			desk.browse(new URI("file:///" + System.getProperty("user.dir").replace("\\", "/")
					+ "/test-output/ExtentReport%20" + formattedDate + "/test-output/SparkReport/Spark.html"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
