package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponants.AbstractComponant;

public class landingPage extends AbstractComponant{

	WebDriver driver;
	public landingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[type='email']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement userPassword;
	
	@FindBy(css="form input:nth-child(3)")
	WebElement submit;
	
	public void loginApplication(String useremail,String userpassword)
	{
		userEmail.sendKeys(useremail);
		userPassword.sendKeys(userpassword);
		submit.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
}
