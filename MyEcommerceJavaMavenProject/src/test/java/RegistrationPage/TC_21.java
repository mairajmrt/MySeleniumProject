package RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_21 {
	
	private WebDriver driver;
	private WebElement privacyPolicyBtnId;

	@Test
	
	public void verfiyPrivacyPolicyButton() {
		
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		privacyPolicyBtnId=driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyBtnId.click();
		
		//If privacy policy button is selected by default then below condition will execute otherwise test will fail.
		Assert.assertTrue(privacyPolicyBtnId.isSelected());
		
	}

}
