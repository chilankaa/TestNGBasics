package basictestng;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowExample {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
	}

	@Test
	public void verify_newWindow() {
		WebElement click_here = driver.findElement(By.xpath("//a[text()='Click Here']"));
		click_here.click();
		Set<String> windows = driver.getWindowHandles();
//		System.out.println(windows.size());
		String parent_window = driver.getWindowHandle();
//		System.out.println(parent_window);
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String window_id_inSet = itr.next();
			if (!parent_window.equals(window_id_inSet)) {
				driver.switchTo().window(window_id_inSet);
			}
		}
		WebElement new_window = driver.findElement(By.xpath("//h3[text()='New Window']"));
		System.out.println(new_window.getText());
		driver.switchTo().window(parent_window);
		click_here.click();
	}

}
