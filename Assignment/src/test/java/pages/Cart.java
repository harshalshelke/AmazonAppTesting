package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import tests.BaseClass;

public class Cart extends BaseClass {

	private AndroidDriver<AndroidElement> driver;

	ExtentTest test = extent.createTest("Cart page Test",
			"Test case for Selecting a random product for checking description");

	By openCart = By.id("com.amazon.mShop.android.shopping:id/action_bar_cart_image"); // Cart button at the top right
																						// corner

	public void checkout() {

		test.log(Status.INFO, "Method for checking out by going into cart");

		waitingForVisibilityOfElements(openCart);
		Perform_click_operation(openCart);
		test.log(Status.PASS, "Clicked on cart and proceeded to check out");

	}

	By productNameFromCart = By.xpath("//*[@content-desc]//*[@class='android.widget.TextView']"); // Name of the product
																									// added in cart

	public String retriveProductNameFromCart() {
		test.log(Status.INFO, "Method of getting info of product added in cart");

		waitingForVisibilityOfElements(productNameFromCart);
		String name = getProductInfo(productNameFromCart);
		test.log(Status.PASS, "Info about product in the cart retrieved");

		return name;

	}

}
