package core;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SignUpPageTest {
	
	String baseUrl = "http://learn2test.net/qa/apps/sign_up/v1/";
	
	String expected_title = "Welcome to Sign Up v1";
	String confTitle = "Confirmation";
	
	String title_facebook_expected = "Welcome to Facebook - Log In, Sign Up or Learn More";
	
	String error_expected = "Please enter First Name";
		
	String currentCity = "San Francisco, CA";
	String fname = "Alex";
	String lname = "Moore";
	String email = "alexmoore@gmail.com";
	String phone = "415 555-1212";
	String gender = "Male";
	String state = "California";
	Boolean terms = true;
	String cterms = "Agreed";
	
	SignUpPage sup = new SignUpPage(driver);
	static WebDriver driver = new FirefoxDriver();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void test_01_Verify_title() {
		sup.verify_title(expected_title, baseUrl);
	}

	@Test
	public void test_02_Verify_link() {
		sup.verify_link(title_facebook_expected);
	}

	@Test
	public void test_03_Verify_error_handling() {
		sup.verify_error_handling(error_expected);
	}

	@Test
	public void test_04_Verify_submit_form() {
		sup.verify_submit_form(fname, lname, email, phone, gender, state, terms, cterms, confTitle);
	}
	
	@Test
	public void test_05_VerifyContent() {
		sup.verifyContent(baseUrl, currentCity);
	}


}
