package basictestng;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "Test data for amazon")
	public Object[][] productList() {
		return new Object[][] { { "shoe" }, { "watch" }, { "phone" } };
	}
}
