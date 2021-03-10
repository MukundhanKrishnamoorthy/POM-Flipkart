package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import WebElements.Elements;

public class EdgeExecution {

	@Parameters("browser")
	@Test (enabled = true)
	public static void edgetest(String browser) throws Exception {

		if (browser == "edge") {
			
			System.out.println("Inside edge execution");
			System.setProperty("webdriver.edge.driver", "D:\\Drivers\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			
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
