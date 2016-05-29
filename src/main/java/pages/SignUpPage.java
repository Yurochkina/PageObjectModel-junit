package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	
	WebDriver driver; 
	
	public SignUpPage(WebDriver wd) {
		
		driver = wd;
	}
		
		
    public String verify_HTML_title(){
					
			String title_sign_up_actual = driver.getTitle();
			return title_sign_up_actual;
               
					
	}
    
    public void submit_form(String first_name, String last_name, String email, String phone_number, String gender,String state, String terms ){
    	
    	driver.findElement(By.id("id_fname")).sendKeys(first_name);
    	driver.findElement(By.id("id_lname")).sendKeys(last_name);
    	driver.findElement(By.id("id_email")).sendKeys(email);
    	driver.findElement(By.id("id_phone")).sendKeys(phone_number);
    	if (gender.equals("Male")){
    		driver.findElement(By.id("id_g_radio_01")).click();
    	}
    	else{
    		driver.findElement(By.id("id_g_radio_02")).click();
    	}
    	Select select = new Select(driver.findElement(By.id("id_state")));
    	select.selectByVisibleText(state);
    	
    	if (terms.equals("Checked")) {
    		driver.findElement(By.id("id_checkbox")).click();
    	}
    	
    	driver.findElement(By.id("id_submit_button")).click();
    	
    	
    }
    
    public String verify_error_handling(String first_name){
    	
    	driver.findElement(By.id("id_fname")).sendKeys(first_name);
    	driver.findElement(By.id("id_submit_button")).click();
    	String errorMessage = driver.findElement(By.id("ErrorLine")).getText();
    	return errorMessage;
    }

				

				

				

				
			
				
				
			
  }
		
	


