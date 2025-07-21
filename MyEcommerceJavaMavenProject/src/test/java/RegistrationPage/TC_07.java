package RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_07 {
	@Test

	public static void getRegistrationPage() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText(),
				"Register Account");
	}

}
