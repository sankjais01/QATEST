package main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver createDriver(String type) {
		if (type.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//QATEST//com.lib//chrome//chromedriver.exe");
			driver = new ChromeDriver();
		}

		return driver;

	}

}
