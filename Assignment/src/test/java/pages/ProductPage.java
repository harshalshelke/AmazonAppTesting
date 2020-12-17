package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import tests.BaseClass;




public class ProductPage extends BaseClass {
    
	ExtentTest test = extent.createTest("Products page Test", "Test case for Selecting a random product for checking description");
	
	By suggestedProductList = By.xpath(
			"//*[@class='android.widget.LinearLayout']//*[@resource-id='com.amazon.mShop.android.shopping:id/list_product_linear_layout']");	//List of all the projects suggested for us
	By productSelected = By.className("android.widget.LinearLayout");		//The item we are going to select for 
	By add_To_Cart_button = By.xpath("//*[@resource-id='a-autoid-2']//*[@class='android.widget.Button']");			//add to cart button
	By productInfo = By.xpath("//*[@resource-id='title_feature_div']//*[@class='android.view.View']");				//Information of product 
	
	
	private AndroidDriver<AndroidElement> driver;
	
	public void RandomProductselectionforproductpage() throws InterruptedException {
		
		test.log(Status.INFO, "Method for product selection");

		
		Thread.sleep(3000);
		waitingForVisibilityOfElements(suggestedProductList);
	
		test.log(Status.INFO, "Selecting a random product from the suggested product list");

		RandomSelection(suggestedProductList, productSelected);
		
		test.log(Status.PASS, "Selected...");

	}


	public void addToCart() throws InterruptedException {
		
		test.log(Status.INFO, "Method for Adding the product to the cart");
	
		Thread.sleep(4000);
		
		test.log(Status.INFO, "Scrolling/swiping up the page till the add to cart button is visible ");

		scroll();
		
		System.out.println("swipe is performed in add to cart");
		test.log(Status.PASS, "Scrolled...");

		Perform_click_operation(add_To_Cart_button);
		test.log(Status.PASS, "Pressing add to cart button");

	}


	public String retriveProductInfo() {
		
		test.log(Status.INFO, "Method for retrieving the information of the product which is going to added in the cart");

		// TODO Auto-generated method stub
		waitingForVisibilityOfElements(productInfo);
		String name = getProductInfo(productInfo);
		test.log(Status.PASS, "Info collected");

		return name;
		
		
	}
	
}
