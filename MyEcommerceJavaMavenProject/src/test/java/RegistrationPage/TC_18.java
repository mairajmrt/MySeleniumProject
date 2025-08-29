package RegistrationPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GlobalUtility.CommonUtils;

public class TC_18 {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	String firstname;
	String lastname;
	String email;
	String telephone;
	String password;
	String confirm;

	@Test

	public void getRegisterFromOracleDatabase() {
		try {
			conn = CommonUtils.getOracleDatabseConnection();
			// Create statement.............
			stmt = conn.createStatement();
			// Execute query....................
			rs = stmt.executeQuery("select * from ali");
			while (rs.next()) {

				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				email = rs.getString("email");
				telephone = rs.getString("telephone");
				password = rs.getString("password");
				confirm = rs.getString("confirm");
				break;
			}
			
			//User registration from database values 
			
			if(email=="alimrt@gmail.com") {

			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.linkText("My Account")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-firstname")).sendKeys(firstname);
			driver.findElement(By.id("input-lastname")).sendKeys(lastname);
			driver.findElement(By.id("input-email")).sendKeys(email);
			driver.findElement(By.id("input-telephone")).sendKeys(telephone);
			driver.findElement(By.id("input-password")).sendKeys(password);
			driver.findElement(By.id("input-confirm")).sendKeys(confirm);
			driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			}

			// Clean up..................
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception exe) {
			System.out.println("Error By Me...." + exe);
		}

	}

}
