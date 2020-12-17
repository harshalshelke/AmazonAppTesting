package Tester;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.Status;

import pages.Cart;
import pages.HomePage;
import pages.ProductPage;

import pages.SignInPage;
import tests.BaseClass;

public class EbayTester extends BaseClass {
	ExtentTest test;

	public EbayTester() {
		// TODO Auto-generated constructor stub
		super();
	}

	@BeforeTest
	public void before()

	{
		System.out.println("111");
		test = extent.createTest("Desired capabilities");

		System.out.println("112");
		test.log(Status.INFO, "Desired capabilities to run the android setup using appium");

		System.out.println("113");

		desiredCapabilitiesSetup();

		System.out.println("after base in before");
		test.log(Status.PASS, "Successfully started the application in android device");

	}

	@Test
	public void Tester() throws Exception {
		test = extent.createTest("Sign in ");
		SignInPage signin = new SignInPage();

		signin.skip();

		test.log(Status.PASS, "Successfully skipped sign in ");

		Capture_screenShot();
		test.log(Status.PASS, "Screenshot captured successfully---1");

		// System.out.println("after base1");
		test = extent.createTest("Basic Product search");
		HomePage home = new HomePage();

		test.log(Status.INFO, "Searching product...");
		home.searchingProduct();
		test.log(Status.PASS, "Product searching done");

		Capture_screenShot();
		test.log(Status.PASS, "Screenshot captured successfully---2");

		// System.out.println("after Homepage");

		test = extent.createTest("Specific Product search");
		ProductPage productsPage = new ProductPage();

		test.log(Status.INFO, "Searching product randomly...");

		productsPage.RandomProductselectionforproductpage();
		System.out.println("after productpage");

		test.log(Status.PASS, "Random selection successful");

		Capture_screenShot();
		test.log(Status.PASS, "Screenshot captured successfully---3");

		test.log(Status.INFO, "Retrieve info of selected product");

		String productName = new ProductPage().retriveProductInfo();
		System.out.println(productName + "fetched from the productsPage");
		ProductPage product_page = new ProductPage();

		test.log(Status.PASS, "Product info retrieved");

		test = extent.createTest("Inside cart");
		Cart cart = new Cart();

		try {

			Capture_screenShot();
			test = extent.createTest("Screenshot captured successfully");
			test.log(Status.PASS, "Screenshot captured successfully---3");

			// System.out.println("after ss");

			// Thread.sleep(3000);
			product_page.addToCart();

			test = extent.createTest("Screenshot captured successfully");
			test.log(Status.PASS, "Successfully product added in the cart");

			cart.checkout();

			test = extent.createTest("Checking out by going into the cart");
			test.log(Status.PASS, "Checking out by going into the cart");

			String cartProductName = cart.retriveProductNameFromCart();
			// System.out.println(cartProductName + "fetched from the Cart");
			test = extent.createTest("Successfully retrieved the name of the product from the cart");
			test.log(Status.PASS, "Successfully retrieved the name of the product from the cart");

			verifyProductInfo(productName, cartProductName);
			test = extent.createTest("Verification done successfully");
			test.log(Status.PASS, "Verification done successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.FAIL, "Some exception has been occured");

		}
	}

}
