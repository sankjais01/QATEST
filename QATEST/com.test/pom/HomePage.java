package pom;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetTagName;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.Locators;

public class HomePage {

	boolean flag = false;
	boolean sliderOneflag = false;
	boolean sliderTwoflag = false;
	boolean sliderThreeflag = false;
	WebDriver driver;
	// WebDriverWait wait = new WebDriverWait(driver, 10000);

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get(Locators.HOMEPAGE_URL);
	}

	@FindBy(xpath = Locators.SLIDERFRAME_XPATH)
	WebElement slider;

	@FindBy(xpath = Locators.SLIDERARROW_PREVIOUS_XPATH)
	WebElement slider_previous_arrow;

	@FindBy(xpath = Locators.SLIDERARROW_NEXT_XPATH)
	WebElement slider_next_arrow;

	@FindBy(xpath = Locators.SLIDERONE_XPATH)
	WebElement slider_one;

	@FindBy(xpath = Locators.SLIDERTWO_XPATH)
	WebElement slider_two;

	@FindBy(xpath = Locators.SLIDERTHREE_XPATH)
	WebElement slider_three;

	@FindBy(xpath = Locators.MENUITEM_SHOP_XPATH)
	WebElement menu_shop;

	@FindBy(xpath = Locators.HOMELOGO_XPATH)
	WebElement HomeLogo;

	List<WebElement> clickableLinks = driver.findElements(By.tagName("a"));

	public int countClickableLink() {
		int count = 0;
		for (WebElement webElement : clickableLinks) {
			if (webElement.getText().length() > 0) {
				// System.out.println(webElement.getText());
				count++;
			}
		}

		return count;
	}

	public boolean checkCkickableLink() {
		int size = countClickableLink();
		String link[] = new String[size];
		int i = 0;
		for (WebElement webElement : clickableLinks) {
			if (webElement.getText().length() > 0) {
				link[i] = webElement.getAttribute("href");
				i++;
			}
		}

		return flag;
	}

	public int countArrivals() {

		List<WebElement> element = driver.findElements(By.xpath("//ul[@class='products']"));
		return element.size();
	}

	public int countSlider() {

		List<WebElement> element = driver.findElements(By.xpath("//*[@class='row_inner']"));
		return element.size();
	}

	public boolean onlyThisSliderAvailabiltyTest() {

		try {
			Assert.assertTrue(slider.isDisplayed(), "Slider is Not loaded");
			Assert.assertTrue(slider_previous_arrow.isDisplayed(), "Previous arrow not visible, unable to slide");
			Assert.assertTrue(slider_next_arrow.isDisplayed(), "Next arrow not visible, unable to slide");
			for (int i = 1; i < 4; i++) {
				slider_previous_arrow.click();
				Thread.sleep(500);
				if (slider_one.isDisplayed()) {
					sliderOneflag = true;
				}
				if (slider_two.isDisplayed()) {
					sliderTwoflag = true;
				}
				if (slider_three.isDisplayed()) {
					sliderThreeflag = true;
				}
			}
			Assert.assertTrue((sliderOneflag && sliderTwoflag && sliderThreeflag), "Slider is missing");
			flag = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
