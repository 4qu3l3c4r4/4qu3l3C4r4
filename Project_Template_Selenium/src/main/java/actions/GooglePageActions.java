package actions;

import org.openqa.selenium.WebDriver;
import pageObjects.GooglePage;
import actions.CommonActions;


public class GooglePageActions {
	WebDriver driver;
	GooglePage googlePage;
	CommonActions commonActions;
	public GooglePageActions(WebDriver driver) {
		this.driver=driver;
		 googlePage = new GooglePage();
		 commonActions = new CommonActions(); 
	}

	
	public void getHomeGoogle() {
		commonActions.OpenURL(driver,googlePage.url);
	}
	
	public void googleSearch(String busca) {
		commonActions.fillInput(driver,googlePage.inputData, busca);
	
	}
	
	public void clickButton() {
		commonActions.click( driver,googlePage.btnSearch);
	
	}
	
}