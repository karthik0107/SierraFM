package com.sierra.stepDefinitions;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.sierra.testbase.BrowserLaunch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OutLook_Login_stepDefini extends BrowserLaunch{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("User navigate to outlook portal Login page")
	public void user_navigate_to_outlook_portal_login_page() throws FileNotFoundException, InterruptedException {
		driver.get("https://login.live.com/");
		driver.manage().window().maximize();
	}

	@When("User enters valid email address for login outlook portal {string}")
	public void user_enters_valid_email_address_for_login_outlook_portal(String emailid) {
		driver.findElement(By.id("i0116")).sendKeys(emailid);
	}

	@When("Clicks on Next button")
	public void clicks_on_next_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
			
	}
	@When("Ueer enters valid password for outlook {string}")
	public void ueer_enters_valid_password_for_customer_portal(String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118"))).sendKeys(password);
	}
	@When("Clicks on Login button for outlook")
	public void clicks_on_login_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
	}
	@When("Clicks on Yes button")
	public void clicks_on_yes_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
	}

	@When("Clicks on Menu button")
	public void clicks_on_menu_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"O365_MainLink_NavMenu\"]"))).click();
	}
	@When("Clicks on Outlook")
	public void clicks_on_outlook() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("O365_AppTile_Mail"))).click();
	}

	@SuppressWarnings("deprecation")
	@Then("User should login successfully")
	public void user_should_login_successfully() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login Successful");
		}
	@Then("Clicks on Search")
	public void clicks_on_search() throws InterruptedException {
		Thread.sleep(6000);
		Set<String> Windows =driver.getWindowHandles();
        Iterator<String> Itr=Windows.iterator();
		@SuppressWarnings("unused")
		String Parent = Itr.next();
        String Child1=Itr.next();
        Thread.sleep(6000);
        driver.switchTo().window(Child1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topSearchInput"))).click();
	}
	
	@Then("Search the Workorder Id {string}")
	public void search_the_workorder_id(String OrderID) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topSearchInput"))).sendKeys(OrderID);
	}

	@Then("Clicks on Workorder Id")
	public void clicks_on_workorder_id() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("rSCR0"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Click this link to create the packing list for Order Number:']/following-sibling::a"))).click();
		System.out.println("Order Details Open Successfully");		
		
		/*
		WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"searchSuggestion-0\"]/div/div"));
		Thread.sleep(1000);
		elementToClick.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//b[text()='Click this link to create the packing list for Order Number:']/following-sibling::a")).click();

		*/
		Set<String> windowHandles = driver.getWindowHandles();
		//System.out.println(windowHandles);

		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(2));
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(7000);
		// CCI form click the updated button 
		WebElement elesendKeys = driver.findElement(By.tagName("h1"));
		elesendKeys.getText();
		System.out.println(elesendKeys.getText());		
				
		//driver.findElement(By.cssSelector("ion-row#submit_btns>ion-col>button")).click();		

		//to perform Scroll on application using Selenium
		//js.executeScript("window.scrollBy(0,350)", "");		
		
	}
	
	
	@Then("Click on the Update Package Delivery Details")
	public void click_on_the_update_package_delivery_details() throws InterruptedException {
		
	//Locating element by link text and store in variable "Element"    
	WebElement Element = driver.findElement(By.xpath("//button[@title='Update the shipping details for current/past shipments']"));

	Element.isDisplayed();
				
	// Scrolling down the page till the element is found		
	js.executeScript("arguments[0].scrollIntoView();", Element);
		        
	// Click on the button 
	js.executeScript("arguments[0].click();", Element);
	
	 //accepting javascript alert for popup 
     //Alert alert = driver.switchTo().alert();
     //alert.accept();
	   
    // Clicked the ok button on popup  
    driver.findElement(By.xpath("//span[text()='Ok']")).click();    
    
    Thread.sleep(2000);
    //driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//select)[1]")).click();
       
    // Select the Date:Consignment ID date 
    Select objSelect = new Select(driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//select)[1]")));
    //objSelect.selectByValue("Automation Testing");
    objSelect.selectByIndex(1);
    
    Thread.sleep(1000);
    // Select the Delivery Method field data 
    Select objSelect_DeliveryMethod = new Select(driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered')]//select)[2]")));
    objSelect_DeliveryMethod.selectByValue("Ship (Courier)");
    //objSelect_DeliveryMethod.selectByIndex(1);
    
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='input-group']//input[1]")).click();
    //WebElement webl = driver.findElement(By.xpath("//div[@class='input-group']//input[1]"));
    //js.executeScript("arguments[0].value='02/02/2023';", webl);
      
    
	}
	
}