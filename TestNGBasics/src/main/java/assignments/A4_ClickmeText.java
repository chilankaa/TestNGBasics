package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A4_ClickmeText {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
	}

	@Test
	public void verify_alertText() {
		WebElement clickme = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickme.click();
		String expected_alert="I am a Javascript alert box!";
		String actual_alert=driver.switchTo().alert().getText();
		Assert.assertEquals(actual_alert, expected_alert);
	}
}
