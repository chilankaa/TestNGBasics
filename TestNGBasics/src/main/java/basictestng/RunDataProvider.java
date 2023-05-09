package basictestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunDataProvider {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void launch_chrome() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "Test data for amazon", dataProviderClass = DataProviders.class)
	public void verify_enteredProduct(String product) {
		driver.get("https://www.amazon.in/");
		WebElement searchfield = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchfield.sendKeys(product);
		WebElement searchbutton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();
	}

	@Test(dataProvider = "Test data for facebook", dataProviderClass = DataProviders.class)
	public void verify_enteredProduct(String userid, String password) {
		driver.get("https://www.facebook.com/");
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		username.sendKeys(userid);
		WebElement passwordd = driver.findElement(By.xpath("//input[@name='pass']"));
		passwordd.sendKeys(password);
	}
}
