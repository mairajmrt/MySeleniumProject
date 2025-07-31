package RegistrationPage;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalUtility.CommonUtils;

public class TC_11 {

	@Test

	void getNotValidPhoneNumber() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mairaj");
		driver.findElement(By.id("input-lastname")).sendKeys("Ali");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getNewEmailAddress());
		driver.findElement(By.id("input-telephone")).sendKeys("12");
		driver.findElement(By.id("input-password")).sendKeys("1212");
		driver.findElement(By.id("input-confirm")).sendKeys("1212");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver
				.findElement(By.xpath(("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")))
				.getText(), "Telephone must be between 3 and 32 characters!");

	}

	
}
