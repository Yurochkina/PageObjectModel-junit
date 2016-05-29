package pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POMSignUpTest {

	
		SignUpPage supage = new SignUpPage(driver);
		static WebDriver driver = new FirefoxDriver();
		static String baseURL = "http://learn2test.net/qa/apps/sign_up/v1/";
		
		
		
		@Before
		public  void setUp() throws Exception {
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseURL);
			
		}
		
		@AfterClass
		public  static void tearDown() throws Exception {
			driver.quit();
		}
		
		@Test
		public void test_01_verify_HTML_title() {
			
			
			assertEquals("Page loaded sucessfully", "Welcome to Sign Up v1", supage.verify_HTML_title());
		}
		
		@Test
		public void test_10_verify_submit_form() throws InterruptedException{
			
			supage.submit_form("Olga", "Yurochkina", "olga@gmail.com", "6503456789", "Female", "California", "Checked");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			assertEquals("Form sucessfully submited", "Confirmation", supage.verify_HTML_title());
		}
		
		@Test
		public void test_06_verify_error_handling_first_name(){
		
		assertEquals("Error message is displayed", "Invalid First Name: [a-zA-Z,.'-]{3,30}", supage.verify_error_handling("O"));
		
		}
		

	}



