package basictestng;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "Test data for amazon")
	public Object[][] productList() {
		return new Object[][] { { "shoe" }, { "watch" }, { "phone" } };
	}

	@DataProvider(name = "Test data for facebook")
	public Object[][] useridPassword() {
		return new Object[][] { { "userid", "password" }, { "userid1", "password1" }, { "userid2", "password2" } };
	}
}
