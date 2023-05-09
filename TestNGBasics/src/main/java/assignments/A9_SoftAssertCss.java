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
		String expectedColor="rgba(40, 167, 69, 1)";
		String actualColor=autoclosable_success.getCssValue("background-color");
		softassert.assertEquals(actualColor, expectedColor);
		WebElement autoclosable_warning=driver.findElement(By.xpath("//button[@id='autoclosable-btn-warning']"));
		String expectedColor1="rgba(255, 193, 7, 1)";
		String actualColor1=autoclosable_warning.getCssValue("background-color");
		softassert.assertEquals(actualColor1, expectedColor1);
		WebElement autoclosable_danger=driver.findElement(By.xpath("//button[@id='autoclosable-btn-danger']"));
		String expectedColor2="rgba(220, 53, 69, 1)";
		String actualColor2=autoclosable_danger.getCssValue("background-color");
		softassert.assertEquals(actualColor2, expectedColor2);
		
	}
}
