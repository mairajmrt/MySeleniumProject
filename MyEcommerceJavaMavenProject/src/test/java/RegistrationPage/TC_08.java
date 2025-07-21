package RegistrationPage;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08 {

	@Test

	public static void getWrongPassowrd() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("mairaj");
		driver.findElement(By.id("input-lastname")).sendKeys("ali");
		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9634068065");
		driver.findElement(By.id("input-password")).sendKeys("Maa@1987");
		driver.findElement(By.id("input-confirm")).sendKeys("Maa@198");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),
				"Password confirmation does not match password!");

	}

	public static String getEmailWithTimeStamp() {
		String emailaddress = new Date().toString().replaceAll("\\ ", "").replaceAll("\\:", "") + "@gmail.com";
		return emailaddress;
	}

}
