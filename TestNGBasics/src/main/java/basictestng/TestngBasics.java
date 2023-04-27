package basictestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBasics {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	}

	@Test
	public void verify_url() {
		String expected_url = "https://selenium.obsqurazone.com/siple-form-demo.php";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}

	@Test
	public void verify_buttonText() {
		WebElement show_message = driver.findElement(By.xpath("//button[text()='Show Message']"));
		String expected_text = "submit";
		String actual_text = show_message.getText();
		Assert.assertEquals(actual_text, expected_text,"FAILED");
	}

	@Test
	public void verify_checkboxDemo() {
		WebElement checkbox_demo = driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkbox_demo.click();
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@class='form-check-input']"));
		boolean status = checkbox1.isDisplayed();
//		Assert.assertEquals(true, status);
		Assert.assertTrue(status);
	}
//	@AfterClass
//	public void close_browser() {
//		driver.quit();
//	}
}
