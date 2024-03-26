package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponants.AbstractComponant;

public class CartPage extends AbstractComponant {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	public Boolean verifyProductDisplay(String itemName)
	{
		Boolean match =cartItems.stream().anyMatch((productItems)-> productItems.getText().equalsIgnoreCase(itemName));
		return match;
	}
	
	@FindBy(css="/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")
	WebElement Submit;
	public void checkOut() throws InterruptedException
	{
		By totalRowsSelect=By.cssSelector(".totalRow button");
		waitElementToAppear(totalRowsSelect);
		Thread.sleep(3000);
		Submit.click();
//		CheckOutPage checkoutpage=new CheckOutPage(driver);
//		return checkoutpage;
	}

}
