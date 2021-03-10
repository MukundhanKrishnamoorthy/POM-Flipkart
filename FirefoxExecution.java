package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import WebElements.Elements;

public class FirefoxExecution {

	private static WebDriver driver = null;

	@Parameters("browser")
	@Test (enabled = true)
	public static void firefoxtest(String browser) throws Exception {

		System.out.println(browser);
		if (browser == "firefox") {

			System.out.println("Inside firefox execution");
			System.setProperty("webdriver.firefox.driver", "D:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.get(Elements.input_url());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Elements.search_input(null).sendKeys("iPhone 12");
			Elements.search_icon(driver);
			Elements.first_result(driver);
			Elements.switch_window(driver);
			Elements.add_to_cart(driver);
			Elements.screenshot(driver);
		}
	}
}
