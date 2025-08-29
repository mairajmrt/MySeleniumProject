package RegistrationPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GlobalUtility.CommonUtils;
import junit.framework.Assert;

public class TC_24 {
	@Test

	public void verfiyConfirPassword() {

		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("mairaj");
		driver.findElement(By.id("input-lastname")).sendKeys("ali");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getNewEmailAddress());
		driver.findElement(By.id("input-telephone")).sendKeys("9634068065");
		driver.findElement(By.id("input-password")).sendKeys("Maa@1987");
		driver.findElement(By.id("input-confirm")).sendKeys("Maa@1987");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		//Verify confirm password text field.................
		String expectedmsg="Password confirmation does not match password!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),expectedmsg);	
	}

}
