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

public class A13_TextImageVerification {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/dynamic-load.php");
	}
	@Test
	public void verify_newUserTextAndImageDisplay() {
		WebElement getnewuser = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		String expectedtext="Get New User";
		String actualtext=getnewuser.getText();
		softassert.assertEquals(actualtext, expectedtext);
		getnewuser.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card text-center']//img")));
		WebElement image=driver.findElement(By.xpath("//div[@class='card text-center']//img"));
		softassert.assertTrue(image.isDisplayed());
	}
}
