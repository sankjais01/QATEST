package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	//WebDriverWait wait = new WebDriverWait(driver, 10000);

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = Locators.SLIDERFRAME_XPATH)
	WebElement slider;

	@FindBy(xpath = Locators.SLIDERARROW_PREVIOUS_XPATH)
	WebElement slider_previous_arrow;

	@FindBy(xpath = Locators.SLIDERARROW_NEXT_XPATH)
	WebElement slider_next_arrow;

	/*@FindBy(xpath = Locators.SLIDERONE_XPATH)
	WebElement slider_one;

	@FindBy(xpath = Locators.SLIDERTWO_XPATH)
	WebElement slider_two;

	@FindBy(xpath = Locators.SLIDERTHREE_XPATH)
	WebElement slider_three;*/

	@FindBy(xpath = Locators.MENUITEM_SHOP_XPATH)
	WebElement menu_shop;

	@FindBy(xpath = Locators.HOMELOGO_XPATH)
	WebElement HomeLogo;

	public boolean sliderTest() {

		try {
			driver.get(Locators.HOMEPAGE_URL);
			// wait.until(ExpectedConditions.urlToBe(Locators.HOMEPAGE_URL));
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			menu_shop.click();
			Thread.sleep(2000);
			Assert.assertTrue(HomeLogo.isDisplayed(), "Home logo not visible");
			HomeLogo.click();
			Thread.sleep(2000);
			Assert.assertTrue(slider.isDisplayed(), "Slider is Not loaded");
			Assert.assertTrue(slider_previous_arrow.isDisplayed(), "Previous arrow not visible, unable to slide");
			Assert.assertTrue(slider_next_arrow.isDisplayed(), "Next arrow not visible, unable to slide");
			
			
			
			for (int i = 1; i < 4; i++) {
				slider_previous_arrow.click();
				Thread.sleep(500);
				if (driver.findElement(By.xpath(Locators.SLIDERONE_XPATH)).isDisplayed()) {
					sliderOneflag = true;
				}
				if (driver.findElement(By.xpath(Locators.SLIDERTWO_XPATH)).isDisplayed()) {
					sliderTwoflag = true;
				}
				if (driver.findElement(By.xpath(Locators.SLIDERTHREE_XPATH)).isDisplayed()) {
					sliderThreeflag = true;
				}
				System.out.println("Out to Loop");

				

			}

			Assert.assertTrue((sliderOneflag && sliderTwoflag && sliderThreeflag), "Slider is missing");
			flag = true;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

}
