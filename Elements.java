package WebElements;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {

	public static WebElement element = null;

	public static String input_url() {
		String URL = "https://www.flipkart.com/";
		return URL;
	}
	
	public static WebElement search_input(WebDriver driver) {
		element = driver.findElement(By.xpath("\"//input[@name='q' and @type='text']\""));
		return element;
	}

	public static WebElement search_icon(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='L0Z3Pu' and @type='submit']"));
		return element;
	}

	public static WebElement first_result(WebDriver driver) {
		element = driver.findElement(By.linkText("APPLE iPhone 12 (Blue, 64 GB)"));
		return element;
	}

	public static void switch_window(WebDriver driver) throws Exception {

		String parentHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();

		Iterator<String> itr = allHandles.iterator();
		while (itr.hasNext()) {
			String nextWindow = itr.next();

			if (!parentHandle.equals(nextWindow)) {
				driver.switchTo().window(nextWindow);
			}
		}
	}

	public static void add_to_cart(WebDriver driver) {
		WebElement cartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		cartButton.click();
	}

	public static void screenshot(WebDriver driver) throws Exception {
		// Taking screenshot
		TakesScreenshot pic = ((TakesScreenshot) driver);
		File scrshot = pic.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:\\Flipkart_POJO.png");
		FileUtils.copyFile(scrshot, destFile);
	}
}
