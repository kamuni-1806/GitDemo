package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponants.AbstractComponant;

public class CheckOutPage extends AbstractComponant{

	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement seletCountry;
	
//	driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement actionSubmit;
	
	////button[contains(@class,'ta-item')])[2]
	@FindBy(css="button[contains(@class,'ta-item')])[2]")
	WebElement selectSpecificCountry;
	
	public void selectCountryDropdown()
	{
		Actions a =new Actions(driver);
		a.sendKeys(seletCountry,"India").build().perform();
		By dropdownBy=By.cssSelector("\".ta-results\"");
		waitElementToAppear(dropdownBy);
		selectSpecificCountry.click();
			
	}
	
	public void submitOrder()
	{
		actionSubmit.click();
	}
}
