package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {
	
WebDriver dr;

	@SuppressWarnings("deprecation")
	@Given("the user is on login page of bearberry")
	public void the_user_is_on_login_page_of_bearberry() {
	    
	dr= new ChromeDriver();
	dr.get("https://bearberryindia.com/");
	dr.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);
	dr.manage().window().maximize();
	dr.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		
	}

	@When("user enters the valid data\\(username: {string}, Password: {string})")
	public void user_enters_the_valid_data_username_password(String email, String pas) {
		
		dr.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		dr.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pas);
	    
	}
	    
		
	

	@When("click on login button")
	public void click_on_login_button() {
	    
		dr.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	}

	
	@Then("user should see  my account page")
	public void user_should_see_my_account_page() {
	    
	boolean status=	dr.findElement(By.xpath("//h2[contains(text(),'My Account')]")).isDisplayed();
	Assert.assertEquals(status, true);//org.junit use it 
	dr.quit();
	}



}
