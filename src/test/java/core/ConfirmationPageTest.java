package core;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationPageTest {
	
	String baseUrl = "http://learn2test.net/qa/apps/sign_up/v1/conformation.php";
	String title_page = "Welcome to Sign Up v1";
	
	ConfirmationPage cp = new ConfirmationPage(driver);
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
	public void testVerifyBackbutton() {
		
		cp.verifyBackbutton(title_page, baseUrl);
	}

}
