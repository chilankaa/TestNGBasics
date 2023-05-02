package basictestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert=new SoftAssert();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	}
	@Test
	public void verify_checkboxDemo() {
		WebElement checkbox_demo = driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkbox_demo.click();
		WebElement checkbox1 = driver.findElement(By.xpath("//label[contains(text(),'Click on this check box')]"));
		boolean status = checkbox1.isDisplayed();
		softassert.assertFalse(status);
		String expected_name="Click on this check box";
		String actual_name=checkbox1.getText();
		softassert.assertEquals(actual_name, expected_name);
		softassert.assertAll();
		}
	
}
