package com.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionClass {
	WebDriver driver;
	@Before
	public void beforeScenario() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		

	}
	
	@After
	public void afterScenario(Scenario S) throws IOException {
		if(S.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			System.out.println(screenshotAs);
			File f=new File("C:\\Users\\SAM\\Pictures\\Screenshots\\task.png");
			FileUtils.copyFile(screenshotAs, f);
		}
		driver.quit();

	}
	@Given("user is on adactin page")
	public void user_is_on_adactin_page() {
		driver.manage().window().maximize();
	}

	@When("user should enter {string} and {string} click login")
	public void user_should_enter_and_click_login(String string, String string2) {
		WebElement txtUserName = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		txtUserName.sendKeys(string);
		WebElement textpassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		textpassword.sendKeys(string2);
		WebElement click = driver.findElement(By.xpath("//*[@id=\"login\"]"));
		click.click();
	}

	@When("user should search hotels {string},{string},{string}, {string},{string},{string},{string}and {string}")
	public void user_should_search_hotels_and(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"location\"]"));
		Select s=new Select(findElement);
		s.selectByVisibleText(string);
		driver.findElement(By.xpath("//*[@id=\"hotels\"]")).sendKeys(string2);
		driver.findElement(By.xpath("//*[@id=\"room_type\"]")).sendKeys(string3);
		driver.findElement(By.xpath("//*[@id=\"room_nos\"]")).sendKeys(string4);
		driver.findElement(By.xpath("//*[@id=\"datepick_in\"]")).sendKeys(string5);
		driver.findElement(By.xpath("//*[@id=\"datepick_out\"]")).sendKeys(string6);
		driver.findElement(By.xpath("//*[@id=\"adult_room\"]")).sendKeys(string7);
		driver.findElement(By.xpath("//*[@id=\"child_room\"]")).sendKeys(string8);
		driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
	}

	@When("user should select hotel and click continue")
	public void user_should_select_hotel_and_click_continue() {
		WebElement radiobutton = driver.findElement(By.xpath("//*[@id=\"radiobutton_0\"]"));
		radiobutton.click();

		WebElement cont = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
		cont.click();

	}

	@When("user should book a hotel have to enter {string},{string},{string},{string},{string},{string}, {string}and {string} to book a hotel")
	public void user_should_book_a_hotel_have_to_enter_and_to_book_a_hotel(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(string2);
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys(string3);
		driver.findElement(By.xpath("//*[@id=\"cc_num\"]")).sendKeys(string4);
		driver.findElement(By.xpath("//*[@id=\"cc_type\"]")).sendKeys(string5);
		driver.findElement(By.xpath("//*[@id=\"cc_exp_month\"]")).sendKeys(string6);
		driver.findElement(By.xpath("//*[@id=\"cc_exp_year\"]")).sendKeys(string7);
		driver.findElement(By.xpath("//*[@id=\"cc_cvv\"]")).sendKeys(string8);
		driver.findElement(By.xpath("//*[@id=\"book_now\"]")).click();
		}

	@Then("user should get the order id")
	public void user_should_get_the_order_id() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement order =driver.findElement(By.xpath("//*[@id=\"order_no\"]"));
		String getattribute =order.getAttribute("value");
		System.out.println(getattribute);
	}



}