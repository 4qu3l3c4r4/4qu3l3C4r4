package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import actions.GooglePageActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import enums.DriverType;
import managers.WebDriverManager;
import report.Report;
import report.ReportVideo;

public class GooglePlaceStepDefs {
	WebDriver driver;
	GooglePageActions googlePageActions;
	Report report;
	ReportVideo video;

	@Before
	public void setUp() throws IOException, AWTException {
		driver = WebDriverManager.getDriver(DriverType.CHROME);
		googlePageActions = new GooglePageActions(driver);
		report = new Report(driver);
		video = new ReportVideo();

	}

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws IOException, AWTException {

		googlePageActions.getHomeGoogle();
		video.start();
		report.capturar();

	}
	
	@Then("^he search for \"([^\"]*)\"$")
	public void he_search_for(String search) throws Throwable {
		googlePageActions.googleSearch(search);
		googlePageActions.clickButton();
		report.capturar();
	}

	@After
	public void afterScenario() throws Exception {
		report.createReportDoc();
		report.createReportPdf();
		video.stop();
		driver.close();
		driver.quit();
	}

}