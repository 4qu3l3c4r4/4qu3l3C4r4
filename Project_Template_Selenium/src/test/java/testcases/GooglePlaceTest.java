package testcases;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import actions.GooglePageActions;
import enums.DriverType;
import managers.WebDriverManager;
import report.ExtentReport;
import report.Report;
import report.ReportVideo;
import util.ScreenShot;

public class GooglePlaceTest {
	WebDriver driver;
	GooglePageActions googlePage;
	Report report;
	String phrase = "Selenium - Automação framework automação - O2M";
	ReportVideo video;
	ExtentReport reportHTML = new ExtentReport();

	@Before
	public void setUp() throws IOException, AWTException {

		driver = WebDriverManager.getDriver(DriverType.CHROME);
		googlePage = new GooglePageActions(driver);
		report = new Report(driver);
		video = new ReportVideo();

	}

	@Test
	public void goSearchIntoGoogle() throws Exception {
		reportHTML.test = ExtentReport.extent.startTest("goSearchIntoGoogle");
		googlePage.getHomeGoogle();
		reportHTML.test.log(LogStatus.PASS, "Entrou na página inicial do google");
		report.capturar();
		video.start();
		googlePage.googleSearch(phrase);
		report.capturar();
		reportHTML.test.log(LogStatus.PASS, "Digitou o texto a ser buscado");
		googlePage.clickButton();
		report.capturar();
		reportHTML.test.log(LogStatus.PASS, "Clicou no botão pesquisar");
		video.stop();
		report.createReportDoc();
		report.createReportPdf();
		reportHTML.test.log(LogStatus.PASS, "Caso de teste finalizado com sucesso!");
		reportHTML.extent.endTest(reportHTML.test);

	}

	@Test
	public void testFail() throws Exception {
		reportHTML.test = reportHTML.extent.startTest("testFail");
		try {
			driver.navigate().to("http:\\www.google.com");
			driver.findElement(By.id("lfdksajf")).click();
		} catch (Exception e) {

			reportHTML.test.log(LogStatus.FAIL,
					reportHTML.test.addScreenCapture(ScreenShot.getScreenshot(driver, "print")));
			reportHTML.test.log(LogStatus.FAIL, e.getMessage());
			e.printStackTrace();
			fail();
		}

		reportHTML.extent.endTest(reportHTML.test);

	}

	@After
	public void afterScenario() {

		reportHTML.extent.flush();
		driver.close();
		driver.quit();

	}

}