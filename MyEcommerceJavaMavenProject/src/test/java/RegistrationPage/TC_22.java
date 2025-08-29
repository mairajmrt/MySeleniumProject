package RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_22 {
	
@Test
	
public void verfiyToggledButton() {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
		//verify toggled buttons
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("type"),"password");
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("type"),"password");
		
	}

}
