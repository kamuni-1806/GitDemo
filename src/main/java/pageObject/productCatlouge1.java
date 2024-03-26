package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponants.AbstractComponant;

public class productCatlouge extends AbstractComponant {

	WebDriver driver;
	public productCatlouge(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	public List<WebElement> getProducts()
	{
		By productBy=By.cssSelector(".mb-3");
		waitElementToAppear(productBy);
		return products;
		
	}
	
	@FindBy(xpath="//*[@id=\\\"products\\\"]/div[1]/div[2]/div[1]/div/div/button[2]")
	WebElement addCartProduct;
	
	public void getProductByNameandClick(String productName)
	{
		for(int i=0;i<products.size();i++)
		{
			String singleProduct=products.get(i).findElement(By.cssSelector("b")).getText();
			
				if(singleProduct.equals(productName))
				{
					products.get(i).findElement(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
				}
		}
	}
	
	
	
	public void addProductToCart()
	{
		By ToastXpath=By.xpath("//*[@id=\\\"toast-container\\");
		By animationWaitCss=By.cssSelector(".ng-animating");
		waitElementToDisappear(animationWaitCss);
	}

	
	
}
