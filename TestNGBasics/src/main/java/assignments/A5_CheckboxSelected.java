package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A5_CheckboxSelected {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
	}

	@Test
	public void verify_checkboxSelected() {
		WebElement checkbox = driver.findElement(By.xpath("//input[@class='form-check-input']"));
		checkbox.click();
		boolean status=checkbox.isSelected();
		Assert.assertTrue(status);
	}
}
