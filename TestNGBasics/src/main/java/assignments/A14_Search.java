package assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A14_Search {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();
	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/table-sort-search.php");
	}
	@Test
	public void verify_userDetails() {
		WebElement searchfield=driver.findElement(By.xpath("//input[@type='search']"));
		searchfield.sendKeys("Ashton Cox");
		List<String> expecteddetails=new ArrayList<String>();
		expecteddetails.add("Ashton Cox");
		expecteddetails.add("Junior Technical Author");
		expecteddetails.add("San Francisco");
		expecteddetails.add("66");
		expecteddetails.add("2009/01/12");
		expecteddetails.add("$86,000");
		
		List<WebElement> details=driver.findElements(By.xpath("//table//tbody//tr//td"));
		for(int i=0;i<details.size();i++) {
			String expected=expecteddetails.get(i);
			String actual=details.get(i).getText();
			softassert.assertEquals(actual, expected);
		}
	}
}
