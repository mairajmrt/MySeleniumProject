package RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_23 {

	@Test

	public void verfiyNextPageLocation() {

		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Login']")).click();
		
		// verify location of next page......
		Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']")).getText(), "Returning Customer");
		

	}
}
