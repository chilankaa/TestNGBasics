package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A12_ExplicitExample {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/jquery-progress-bar.php");
	}
	@Test
	public void verify_displayOfComplete() {
		WebElement start=driver.findElement(By.id("downloadButton"));
		start.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='progress-label']")));
		WebElement complete=driver.findElement(By.xpath("//div[@class='progress-label']"));
		softassert.assertTrue(complete.isDisplayed());
	}
}
