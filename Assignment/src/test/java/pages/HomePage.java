package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tests.BaseClass;

public class HomePage extends BaseClass {
	ExtentTest test = extent.createTest("Sign In page Test", "Test case for sign in page and skipping sign in");

	public void searchingProduct() {

		
		try {

			Thread.sleep(2000);

			By searchBox = By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"); // address of search box

			test.log(Status.INFO, "Clicking on search box for search purpose");

			Perform_click_operation(searchBox);

			test.log(Status.PASS, "Clicked on search box");

			test.log(Status.INFO, "Getting the product name to be searched from excel file");

			String name_Of_Product = getValueFromFile();

			test.log(Status.PASS, "Successfully got the value from excel file");

			test.log(Status.INFO, "Sending product name to be searched from excel file to the searchbox");

			sendProductName(searchBox, name_Of_Product);

			test.log(Status.PASS, "Sent");

			test.log(Status.INFO, "List of options we get as a dropdown");
			By listOfOptions = By.xpath(
					"//*[@class='android.widget.ListView']//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_suggestions']");

			By productToBeSelected = By.className("android.widget.LinearLayout"); // addresss of product to be selected
			Thread.sleep(2000);
			waitingForVisibilityOfElements(listOfOptions);
			BaseClass baseClass = new BaseClass();

			
			test.log(Status.INFO, "Selecting a random product from drop dowon");
			baseClass.RandomSelection(listOfOptions, productToBeSelected);
			test.log(Status.PASS, "Selected a product to be searched");

		} catch (Exception e) {
			test.log(Status.FAIL, "Something went wrong");
			e.getCause();
		}

	}

}
