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
		System.out.println("3");
		String expected_url = "c";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}

	@Test(priority = 10, enabled = false)
	public void verify_buttonText() {
		System.out.println("1");
		WebElement show_message = driver.findElement(By.xpath("//button[text()='Show Message']"));
		String expected_text = "submit";
		String actual_text = show_message.getText();
		Assert.assertEquals(actual_text, expected_text,"FAILED");
	}

	@Test(priority = 5, dependsOnMethods ="verify_url" )
	public void verify_checkboxDemo() {
		System.out.println("2");
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
