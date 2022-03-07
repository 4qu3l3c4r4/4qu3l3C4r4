package excel;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import actions.GooglePageActions;
import dataReader.ExcelRead;
import enums.DriverType;
import managers.WebDriverManager;

@RunWith(Parameterized.class)
public class ExcelReadTest {
	private String parametro1;
	private WebDriver driver;
	WebDriverManager webDriverManager;
	GooglePageActions googlePageActions;
	

	public ExcelReadTest(String parametro1) {
		this.parametro1 = parametro1;
	}
	
	@Before
	public void setUp() {
		webDriverManager = new WebDriverManager();
		driver = WebDriverManager.getDriver( DriverType.CHROME);
		googlePageActions = new GooglePageActions(driver);
		
	}

	@Parameterized.Parameters
	public static Collection<Object> input() {
		Object[] objeto = ExcelRead.getArray();
		return Arrays.asList(objeto);
	}
	@Test
	public void searchGoogleTest() {
		googlePageActions.getHomeGoogle();
		googlePageActions.googleSearch(parametro1);
		googlePageActions.clickButton();
	}
	@After
	public void fim() {
		driver.close();
		driver.quit();
	}
	
}
