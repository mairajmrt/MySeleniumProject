package RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_17 {

	private WebDriver driver;

	@AfterMethod
	public void downApplication() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(4000);
			driver.quit();
		}

	}

	@BeforeMethod
	public void setupt() {
		String browserName = "chrome";

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}

		else if (browserName.equals("ie")) {
			driver = new InternetExplorerDriver();
		}

		else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

	}

	@Test

	public void verifyBlankSpace() {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String firstName = "First Name must be between 1 and 32 characters!";
		String lastName = "Last Name must be between 1 and 32 characters!";
		String email = "E-Mail Address does not appear to be valid!";
		String telephone = "Telephone must be between 3 and 32 characters!";
		String password = "Password must be between 4 and 20 characters!";
		
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText(), firstName);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
						.getText(),
				lastName);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
						.getText(),
				email);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
						.getText(),
				telephone);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
						.getText(),
				password);
		;

	}

}
