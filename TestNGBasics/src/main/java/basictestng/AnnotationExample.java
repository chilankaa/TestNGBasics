package basictestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationExample {
	@BeforeSuite
	public void before_suite() {
		System.out.println("Inside before suite");
	}
	@BeforeTest
	public void before_test() {
		System.out.println("Inside before test");
	}
	@BeforeClass
	public void before_class() {
		System.out.println("Inside before classes");
	}
	@BeforeMethod
	public void before_method() {
		System.out.println("Inside before method");
	}
	@Test
	public void testcase1() {
		System.out.println("Inside before test");
	}
	@Test
	public void testcase2() {
		System.out.println("Inside before test2");
	}
	@Test
	public void testcase3() {
		System.out.println("Inside before test3");
	}
	@AfterMethod
	public void after_method() {
		System.out.println("Inside after method");
	}
	@AfterClass
	public void after_class() {
		System.out.println("Inside after class");
	}
	@AfterTest
	public void after_test() {
		System.out.println("Inside after test");
	}
	@AfterSuite
	public void after_suite() {
		System.out.println("Inside after suite");
	}
}
