package RegistrationPage;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TC_27 {

	private FirefoxDriver driver;

	@Test
	public void verifyTakesscreen() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		WebElement mobileID = driver.findElement(By.xpath("//span[@id='cart-total']"));
		File src = mobileID.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\mali204\\git\\MySeleniumProject\\MyEcommerceJavaMavenProject\\image\\abc.png");
		FileHandler.copy(src, dest);
		driver.quit();

	}

}
