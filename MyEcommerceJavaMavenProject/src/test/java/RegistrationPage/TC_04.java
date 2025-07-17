package RegistrationPage;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04 {

	@Test
	public static void getAllFieldsRegistration() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("mairaj");
		driver.findElement(By.id("input-lastname")).sendKeys("ali");
		String emailAddress=getEMailAddress()+"@gmail.com";
		driver.findElement(By.id("input-email")).sendKeys(emailAddress);
		driver.findElement(By.id("input-telephone")).sendKeys("9634068065");
		driver.findElement(By.id("input-password")).sendKeys("adden");
		driver.findElement(By.id("input-confirm")).sendKeys("adden");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	public static String getEMailAddress() {
		Date date=new Date();
		return date.toString().replaceAll("\\s","").replaceAll("\\:","");
	}

}
