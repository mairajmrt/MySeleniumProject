package RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_13 {
	@Test

	public void getVerificationUnderPlaceHolder() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		String firstNamePLaceHolderText = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),
				firstNamePLaceHolderText);
		String lastNamePLaceHolderText = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),
				lastNamePLaceHolderText);
		String emailNamePLaceHolderText = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"),
				emailNamePLaceHolderText);
		String telephoneNamePLaceHolderText = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"),
				telephoneNamePLaceHolderText);
		String passwordNamePLaceHolderText = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"),
				passwordNamePLaceHolderText);
		String confirmNamePLaceHolderText = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"),
				confirmNamePLaceHolderText);

	}

}
