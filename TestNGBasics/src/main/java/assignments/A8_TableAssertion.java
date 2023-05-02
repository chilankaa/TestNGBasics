package assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A8_TableAssertion {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
	}

	@Test
	public void verify_tableHeaders() {
		List<String> text = new ArrayList<String>();
		text.add("Name");
		text.add("Position");
		text.add("Office");
		text.add("Age");
		text.add("Start date");
		text.add("Salary");
		List<WebElement> headers = driver.findElements(By.xpath("//tr[contains(@role,'row')]//th"));
		for (int i = 0; i < headers.size(); i++) {
			String expectedText = text.get(i);
			String actualText = headers.get(i).getText();
			softassert.assertEquals(actualText, expectedText);
		}
	}
	@Test
	public void verify_CedricOffice() {
		WebElement cedricOffice=driver.findElement(By.xpath("//table//tbody//tr[4]//td[3]"));
		String actualText=cedricOffice.getText();
		String expectedText="Edinburgh";
		Assert.assertEquals(actualText, expectedText);
	}
	@Test
	public void verify_footerEntries() {
		WebElement footerEntry=driver.findElement(By.xpath("//div[@class='dataTables_info']"));
		String actualText=footerEntry.getText();
		String expectedText="Showing 1 to 10 of 57 entries";
		Assert.assertEquals(actualText, expectedText);
	}
}
