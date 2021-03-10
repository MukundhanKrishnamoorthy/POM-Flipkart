package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import WebElements.Elements;

public class ChromeExecution {

	
	@Parameters("browser")
	@Test (enabled = true)
	public static void chrometest(String browser) throws Exception {

		if (browser == "chrome") {

			System.out.println("Inside chrome execution");
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

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
