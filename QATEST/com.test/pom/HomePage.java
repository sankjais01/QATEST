package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Locators;

public class HomePage {

	boolean flag = true;
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 10000);

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

	@FindBy(xpath = Locators.SLIDERONE_XPATH)
	WebElement slider_one;

	@FindBy(xpath = Locators.SLIDERTWO_XPATH)
	WebElement slider_two;

	@FindBy(xpath = Locators.SLIDERTHREE_XPATH)
	WebElement slider_three;

	@FindBy(xpath = Locators.MENUITEM_SHOP_XPATH)
	WebElement menu_shop;
	
	
	
	public void sliderTest() {
		
		
		
	}

}
