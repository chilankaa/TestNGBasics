package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A6_FormSubmission {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");

	}

	@Test
	public void verify_confirmationMessage() {
		WebElement subject = driver.findElement(By.xpath("//input[@id='subject']"));
		subject.sendKeys("TestNG");
		WebElement desciption = driver.findElement(By.xpath("//textarea[@id='description']"));
		desciption.sendKeys("Training go on...");
		WebElement submit = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		subject.click();
		WebElement message = driver.findElement(By.xpath("//div[@id='message-one']"));
		boolean status = message.isDisplayed();
		Assert.assertTrue(status);
	}
}
