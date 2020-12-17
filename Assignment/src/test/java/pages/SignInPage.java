package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tests.BaseClass;

public class SignInPage extends BaseClass {
	ExtentTest test = extent.createTest("Sign In page Test");
	
	public void skip() {

		try {
			
			System.out.println("111");
			 test = extent.createTest("Sign In page Test");
			 System.out.println("112");

			test.log(Status.INFO, "Pressing on skip sign in button");
			 System.out.println("113");

			Thread.sleep(8000);
			 

			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();

			test.log(Status.PASS, "Pressed Skip sign in button ");
		} catch (Exception e) {
			test.log(Status.FAIL, "Something went wrong while pressing skipping sign in");
			
			e.printStackTrace();

		}
	}

}
