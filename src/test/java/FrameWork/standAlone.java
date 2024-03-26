package FrameWork;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObject.CartPage;
import pageObject.CheckOutPage;
import pageObject.OrderDetailsAndID;
import pageObject.landingPage;
import pageObject.productCatlouge;

public class standAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Welcome!");
		System.out.println("Welcome!!");
		System.out.println("Welcome!!!");
		
		/*Edge Code*/
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("--start-maximized");
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\Lenovo\\drivers\\msedgedriver.exe");
//		WebDriver driver=new EdgeDriver(options);
//		driver.get("https://rahulshettyacademy.com/client/");
		
		/* Chrome Driver Code*/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Lenovo\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		
		/*Page object Model Framework*/
		
		landingPage landingpage=new landingPage(driver);
		landingpage.goTo();
		landingpage.loginApplication("mohitumesh@gmail.com","Mohit@123");
		productCatlouge productcatlouge = new productCatlouge(driver);
		
		
		List<WebElement> products = productcatlouge.getProducts();
		productcatlouge.getProductByNameandClick("ZARA COAT 3");
		productcatlouge.addProductToCart();
		
		CartPage cartPage=new CartPage(driver);
		Boolean matchProduct =cartPage.verifyProductDisplay("ZARA COAT 3");
		Assert.assertFalse(matchProduct);
		cartPage.checkOut();
		
		CheckOutPage checkoutpage=new CheckOutPage(driver);
		checkoutpage.selectCountryDropdown();
		checkoutpage.submitOrder();
		
		OrderDetailsAndID orderDetailsAndID=new OrderDetailsAndID(driver);
		String orderId=orderDetailsAndID.collectOrderDetails();
		Assert.assertTrue(orderId.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();

	}

}
