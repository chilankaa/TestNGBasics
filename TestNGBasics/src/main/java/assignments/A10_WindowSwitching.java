package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class A10_WindowSwitching {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
	}

	@Test
	public void verify_newWindow() {
		WebElement facebook = driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		facebook.click();
		Set<String> windows = driver.getWindowHandles();
		String parent_window = driver.getWindowHandle();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String window_id_inSet = itr.next();
			if (!parent_window.equals(window_id_inSet)) {
				driver.switchTo().window(window_id_inSet);
			}
		}
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Connect with Obsqura Zone on Facebook']")));
		WebElement connectobsqura = driver
				.findElement(By.xpath("//span[text()='Connect with Obsqura Zone on Facebook']"));
		System.out.println(connectobsqura.getText());
	}

	@Test
	public void verify_facebookButton() {
		WebElement followall = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		followall.click();
		Set<String> windows = driver.getWindowHandles();
		String parent_window = driver.getWindowHandle();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			for (int i = 0; i < 2; i++) {
				String window_id_inSet = itr.next();
				if (!parent_window.equals(window_id_inSet)) {
					driver.switchTo().window(window_id_inSet);
				}
				parent_window = itr.next();
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft x1j85h84' and text()='Log in']")));
		WebElement login = driver.findElement(By.xpath(
				"//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft x1j85h84' and text()='Log in']"));
		softassert.assertTrue(login.isDisplayed());
	}
}
