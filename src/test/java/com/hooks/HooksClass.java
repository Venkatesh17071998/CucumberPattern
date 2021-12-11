package com.hooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksClass {
	WebDriver driver;
	@Before
	public void beforeScenario() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();

	}
	@After
	public void afterScenario(Scenario S) {
		if(S.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshotAs=ts.getScreenshotAs(OutputType.BYTES);
			S.embed(screenshotAs, "sd.png");
		}
		driver.quit();

	}
	

}
