package RegistrationPage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_25 {

	@Test
	public void verifyRegisterPage() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		String expectedTitle= "Register Account";
		String actualTitle = driver
				.findElement(By.xpath("//h1[normalize-space()='Register Account']"))
				.getText();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		String expectedPageUrl= "https://tutorialsninja.com/demo/index.php?route=account/register";
		String actPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(actPageUrl, expectedPageUrl);
		driver.quit();
	}

}
