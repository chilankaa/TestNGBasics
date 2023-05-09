package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A11_ToolTip {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
	}

	@Test
	public void verify_tooltip() {
		WebElement facebook = driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		String expectedtooltip = "Follow @obsqurazone on Facebook";
		String actualtooltip = facebook.getAttribute("Title");
		softassert.assertEquals(actualtooltip, expectedtooltip);
		WebElement followall = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		String expectedtooltip1 = "Follow @obsqurazone";
		String actualtooltip1 = facebook.getAttribute("Title");
		softassert.assertEquals(actualtooltip1, expectedtooltip1);
	}
}
