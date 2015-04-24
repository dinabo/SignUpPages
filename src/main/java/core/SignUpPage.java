package core;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	WebDriver driver;
	
	public SignUpPage(WebDriver wd) {
		driver = wd;
		}
	
	//method for title verification
	public void verify_title(String expected_title, String baseUrl){
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String actual_title = driver.getTitle();
		assertEquals(expected_title, actual_title);
	}
	
	//method for facebook link verification
	public void verify_link(String title_facebook_expected){
		driver.findElement(By.id("id_img_facebook")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		ArrayList<String> allTabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		String actual_title = driver.getTitle();
		driver.close();
		driver.switchTo().window(allTabs.get(0));
		assertEquals(title_facebook_expected, actual_title);
	} 
	
	//method for error-handling verification
	public void verify_error_handling(String error_expected ){
		driver.findElement(By.id("id_submit_button")).click();
		String error_actual = driver
				.findElement(By.id("ErrorLine")).getText();
		assertEquals(error_expected, error_actual);
		}
	
	//method for submit form verification
	public void verify_submit_form(String fname, String lname, String email, 
			String phone, String gender, String state, Boolean terms, String cterms, String confTitle){
		driver.findElement(By.id("id_fname")).clear();
		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_lname")).clear();
		driver.findElement(By.id("id_lname")).sendKeys(lname);
		driver.findElement(By.id("id_email")).clear();
		driver.findElement(By.id("id_email")).sendKeys(email);
		driver.findElement(By.id("id_phone")).clear();
		driver.findElement(By.id("id_phone")).sendKeys(phone);
		if (gender.equalsIgnoreCase("male")){
			driver.findElement(By.id("id_g_radio_01")).click();
			}else if(gender.equalsIgnoreCase("female")){
			driver.findElement(By.id("id_g_radio_02")).click();
			}
			if (terms == true){
			driver.findElement(By.id("id_checkbox")).click();
			}
			if (state.isEmpty()){
			}else{
			new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(state);
			}
		driver.findElement(By.id("id_submit_button")).click();
		
		String fname_conf_actual = driver.findElement(By.id("id_fname_conf"))
				.getText();
		String lname_conf_actual = driver.findElement(By.id("id_lname_conf"))
				.getText();
		String email_conf_actual = driver.findElement(By.id("id_email_conf"))
				.getText();
		String phone_conf_actual = driver.findElement(By.id("id_phone_conf"))
				.getText();
		String gender_conf_actual = driver.findElement(By.id("id_gender_conf"))
				.getText();
		String state_conf_actual = driver.findElement(By.id("id_state_conf"))
				.getText();
		String terms_conf_actual = driver.findElement(By.id("id_terms_conf"))
				.getText();
		assertEquals(driver.getTitle(), confTitle);
		assertEquals(fname, fname_conf_actual);
		assertEquals(lname, lname_conf_actual);
		assertEquals(email, email_conf_actual);
		assertEquals(phone, phone_conf_actual);
		assertEquals(gender, gender_conf_actual);
		assertEquals(state, state_conf_actual);
		assertEquals(cterms, terms_conf_actual);
	}
	
	//method for content verification
	public void verifyContent(String baseUrl, String currentCity){
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String currentCity_actual = driver.findElement(By.id("id_current_location"))
				.getText();	
		assertEquals(currentCity_actual, currentCity);
	}
}
