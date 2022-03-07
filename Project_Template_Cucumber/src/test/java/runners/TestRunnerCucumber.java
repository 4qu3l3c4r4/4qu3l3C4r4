package runners;

import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import util.Constants;


@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = "src/test/java/features",
	glue= {"stepDefinitions"},
	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	monochrome = true,
	tags = {"@Test2"})
 

public class TestRunnerCucumber {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(Constants.HTML_PATH));
	    Reporter.setSystemInfo("Tester", System.getProperty("user.name"));
	   
	}
	
	
	
}