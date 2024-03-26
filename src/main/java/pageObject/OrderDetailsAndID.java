package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponants.AbstractComponant;

public class OrderDetailsAndID extends AbstractComponant{

	WebDriver driver;
	public OrderDetailsAndID(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement getOrderID;
	
	public String collectOrderDetails()
	{
		By orderId=By.cssSelector(".hero-primary");
		waitElementToAppear(orderId);
		String confirmMessage=getOrderID.getText();
		return confirmMessage;
	}

}
