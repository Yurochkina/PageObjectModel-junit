package pages;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class POMSignUpTest {

	
		//SignUpPage supage = new SignUpPage(driver);
	    SignUpPage supage = PageFactory.initElements(driver, SignUpPage.class);
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
		
		@Test
		public void test_12_verify_content_current_city(){
			assertEquals("San Francisco, CA", supage.verify_content());
		}
		
		@Test 
		public void test_11_verify_content_quotes() throws IOException {
			
			//FileReader filereader = new FileReader("/Users/Yurochkina/Documents/workspace/pom-junit/src/test/resources/TestData/quotes.txt");
			FileReader filereader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/TestData/quotes.txt");
			BufferedReader bfreader = new BufferedReader(filereader);
	    	String instring;
	    	final List <String> quotes = new ArrayList();
	    	while((instring = bfreader.readLine()) !=null) {
	    		
	    		quotes.add(instring);
	    		
	    		 
	    	}
	    	
	    	filereader.close();
			
			boolean  quoteMatch = false;
			
			
			
			if (quotes.contains(supage.verify_content_quotes())){
				
				quoteMatch = true; 
				
			
					
				}
			
			else{
				
	
			}
			
		
			assertEquals(true, quoteMatch);
		}
		
		
		
		

	}



