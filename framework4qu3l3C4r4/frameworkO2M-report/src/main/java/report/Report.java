package report;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.Constants;

public class Report {

	WebDriver driver;
	String pathPrint = Constants.PRINTS_PATH;
	ArrayList<String> prints;
	Pdf pdf;
	/**
	 * Construtor da classe Report
	 * @param Webdriver driver
	 * @author fernando.f.andrade
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Report(WebDriver driver) {
		this.driver = driver;
		this.prints = new ArrayList();
	}

	/**
	 * Método para capturar prints que serão utilizados nos relatórios DOC e PDF.
	 * @return void
	 * @author fernando.f.andrade
	 */
	public void capturar() throws IOException {
		String namePrint = "print";
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(pathPrint + namePrint + "_" + dateFormat.format(date) + ".png"));
		prints.add(pathPrint + namePrint + "_" + dateFormat.format(date) + ".png");
	}
	/**
	 * Método para para gerar o relatótio PDF.
	 * @return void
	 * @author fernando.f.andrade
	 */
	public void createReportPdf() throws Exception {
		pdf = new Pdf(prints);

	}
	/**
	 * Método para gerar o relatório DOC..
	 * @return void
	 * @author fernando.f.andrade
	 */
	public void createReportDoc() throws Exception {
		@SuppressWarnings("unused")
		Doc report = new Doc(prints);
	}

}