package core;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
WebDriver driver;
	
	public ConfirmationPage(WebDriver wd) {
		driver = wd;
		}
	//method for back button verification
	 public void verifyBackbutton(String title_page, String baseUrl){
		 driver.get(baseUrl);
		 driver.findElement(By.id("id_back_button")).click();
		 assertEquals(driver.getTitle(), title_page);
		 }
	
	
}
