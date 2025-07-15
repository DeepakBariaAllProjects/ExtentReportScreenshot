package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Base;

//@Listeners(listeners.MyListeners.class)
public class Login extends Base {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void VerifyLogin() {
		Assert.assertEquals(false, false);
	}
	@Test(priority = 2)
	public void VerifyHome() {
		Assert.assertEquals(false, true);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
