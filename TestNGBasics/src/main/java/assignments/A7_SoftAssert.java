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

public class A7_SoftAssert {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/bootstrap-dual-list.php");
	}

	@Test
	public void verify_allOptionsText() {
		List<String> text = new ArrayList<String>();
		text.add("Option 1");
		text.add("Option 2");
		text.add("Option 4");
		text.add("Option 5");
		text.add("Option 7");
		text.add("Option 8");
		text.add("Option 9");
		text.add("Option 10");
		List<WebElement> option = driver.findElements(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option"));
		for (int i = 0; i < option.size(); i++) {
			String expectedText = text.get(i);
			String actualText = option.get(i).getText();
			softassert.assertEquals(actualText, expectedText);
		}
//		WebElement option1 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[1]"));
//		String expectedText = "Option 1";
//		String actualText = option1.getText();
//		Assert.assertEquals(actualText, expectedText);
//		WebElement option2 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[2]"));
//		String expectedText2 = "Option 2";
//		String actualText2 = option1.getText();
//		Assert.assertEquals(actualText2, expectedText2);
//		WebElement option3 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[3]"));
//		String expectedText3 = "Option 4";
//		String actualText3 = option1.getText();
//		Assert.assertEquals(actualText3, expectedText3);
//		WebElement option4 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[4]"));
//		String expectedText4 = "Option 5";
//		String actualText4 = option1.getText();
//		Assert.assertEquals(actualText4, expectedText4);
//		WebElement option5 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[5]"));
//		String expectedText5 = "Option 7";
//		String actualText5 = option1.getText();
//		Assert.assertEquals(actualText5, expectedText5);
//		WebElement option6 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[6]"));
//		String expectedText6 = "Option 8";
//		String actualText6 = option1.getText();
//		Assert.assertEquals(actualText6, expectedText6);
//		WebElement option7 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[7]"));
//		String expectedText7 = "Option 9";
//		String actualText7 = option1.getText();
//		Assert.assertEquals(actualText7, expectedText7);
//		WebElement option8 = driver.findElement(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option[8]"));
//		String expectedText8 = "Option 10";
//		String actualText8 = option1.getText();
//		Assert.assertEquals(actualText8, expectedText8);
		
	}
}
