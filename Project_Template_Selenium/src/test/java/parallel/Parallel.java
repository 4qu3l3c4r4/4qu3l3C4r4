package parallel;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import actions.GooglePageActions;
import enums.DriverType;
import managers.WebDriverManager;

@RunWith(Parameterized.class)
public class Parallel {
	int position = 0;
	DriverType browser;
	private WebDriver driver;
	WebDriverManager webDriverManager;
	GooglePageActions googlePageActions;

	public Parallel(DriverType browser) {
		this.browser = browser;
	}

	@Parameters(name = "Browser Type: {0}")
	public static Collection<?> data() {
		return Arrays.asList(
				new Object[][] { { DriverType.INTERNETEXPLORER }, { DriverType.CHROME }, { DriverType.FIREFOX } });
	}

	@Test
	public void test() throws InterruptedException {
		driver = WebDriverManager.getDriver(browser);
		googlePageActions = new GooglePageActions(driver);
		googlePageActions.getHomeGoogle();
		if (browser.equals(DriverType.FIREFOX)) {
			resizeBrowser();
			driver.manage().window().setPosition(new Point(0,0));
		}
		if (browser.equals(DriverType.CHROME)) {
			resizeBrowser();
			driver.manage().window().setPosition(new Point(500,0));
		}
		if (browser.equals(DriverType.INTERNETEXPLORER)) {
			resizeBrowser();
			driver.manage().window().setPosition(new Point(1000,0));
		}
		
		googlePageActions.googleSearch(browser.toString());
		googlePageActions.clickButton();
		Thread.sleep(10000);
		driver.close();
		driver.quit();
		

	}

	public void resizeBrowser() {
		Dimension d = new Dimension(500, 800);
		driver.manage().window().setSize(d);
		
	}

}
