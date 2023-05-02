package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A9_SoftAssertCss {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/bootstrap-alert.php");
	}

	@Test
	public void verify_buttonColors() {
		WebElement autoclosable_success=driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
		System.out.println(autoclosable_success.getCssValue("background-color"));
	}
}
