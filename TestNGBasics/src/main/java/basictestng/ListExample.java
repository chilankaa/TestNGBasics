package basictestng;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/bootstrap-dual-list.php");
		List<String> text = new ArrayList<String>();
		text.add("Option 1");
		text.add("Option 2");
		text.add("Option 4");
		text.add("Option 5");
		text.add("Option 7");
		text.add("Option 8");
		text.add("Option 9");
		text.add("Option 10");
		List<WebElement> option = driver
				.findElements(By.xpath("//select[@name='duallistbox_demo1[]_helper1']//option"));
		for (int i = 0; i < option.size(); i++) {
			String expectedText = text.get(i);
			String actualText = option.get(i).getText();
			if ((text.get(i)).equals(option.get(i).getText())) {
				System.out.println(actualText + "??" + expectedText);
			}
		}
	}
}
