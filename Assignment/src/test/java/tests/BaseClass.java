package tests;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass extends ExtentReportsForReporting{

	// protected static AppiumDriver<WebElement> driver;

	protected static AppiumDriver driver;
//     ExtentTest test =extent.createTest("BaseClass");

	public void desiredCapabilitiesSetup() {
		try {
			
			
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("deviceName", "OnePlus 7");// To set the Device name
			caps.setCapability("udid", "26999d26");
			caps.setCapability("platformName", "Android");// To set the OS name
			caps.setCapability("platformVersion", "10");// To set the Android version
			// caps.setCapability(MobileCapabilityType.app, value);
			caps.setCapability("appPackage", "com.amazon.mShop.android.shopping");
			caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<WebElement>(url, caps);
		//	test.log(Status.PASS, "Used DesiredCapablities method");
		} catch (Exception e) {
			e.getCause();
			e.printStackTrace();
		}

	}

	public void Perform_click_operation(By element) {
		driver.findElement(element).click();
	//	test.log(Status.PASS, "Used Perform_click_operation  method");
	}

	public void waitingForVisibilityOfElements(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
		//test.log(Status.PASS, "Used waitingForVisibilityOfElements  method");
	}

	public void sendProductName(By element, String excelValue) {
		driver.findElement(element).click();
		driver.findElement(element).sendKeys(excelValue);
//		test.log(Status.PASS, "Used sendProductName method");

	}

	public void RandomSelection(By listElement, By ProductToBeSelected) {
		try {
			List<WebElement> searchList = driver.findElements(listElement);
			Random random = new Random();

			System.out.println("In randomselection");
			int index = random.nextInt(searchList.size());

			System.out.println("In randomselection index" + index);

			searchList.get(index).findElement(ProductToBeSelected).click();
		
			//test.log(Status.PASS, "Used RandomSelection method");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProductInfo(By element) {
		String textValue = driver.findElement(element).getText();
		
	//	test.log(Status.PASS, "Used getProductInfo method");

		return textValue;
		
	}

	public void verifyProductInfo(String name, String cartProductElement) {
		String message = "";
		try {
			if (cartProductElement.contains(name)) {
				message = "Verification Done";
				Assert.assertTrue(true, message);

			} else {
				Assert.assertFalse(false);
				message = "verfication Failed";

			}

			System.out.println(message);
			
//			test.log(Status.PASS, "Used verifyProductInfo method");

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
	}

	public String getValueFromFile() throws Exception {

		File file = new File(
				"C:\\Users\\Harshal Shelke\\eclipse-workspace\\Assignment\\src\\test\\resources\\DataProvider.xlsx");

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// String Productname = null;
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(0);
		String name = cell.getStringCellValue();
		workbook.close();
		//test.log(Status.PASS, "Used getValueFromFile method");

		return name;

	}

	public void scroll() { // change x and y

		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(700, 1850)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(1000, 300)).release().perform();
	//	test.log(Status.PASS, "Used scroll method");

	}

	public void Capture_screenShot() throws Exception {
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		String fileNameOfss = dateFormat.format(new Date()) + ".png";
		FileUtils.copyFile(ss, new File(
				"C:\\Users\\Harshal Shelke\\eclipse-workspace\\Assignment\\src\\test\\resources\\Screenshots\\image"
						+ fileNameOfss));
		
	//	test.log(Status.PASS, "Used Capture_screenShot method");

	}

}
