package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A3_ButtonTextDisplay {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
	}

	@Test
	public void verify_buttonDisplay() {
		WebElement show_selected = driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean status=show_selected.isDisplayed();
		Assert.assertFalse(status); 
		System.out.println("Printed..");
	}
	@Test
	public void verify_buttonText() {
		WebElement show_selected = driver.findElement(By.xpath("//button[@id='button-one']"));
		String expected_text = "Show Selected Value";
		String actual_text = show_selected.getText();
		Assert.assertEquals(actual_text, expected_text);
	}
}
