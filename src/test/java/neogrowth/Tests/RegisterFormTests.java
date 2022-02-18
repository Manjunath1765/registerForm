package neogrowth.Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import neogrowth.pageObjects.HomePageObjects;
import neogrowth.pageObjects.RegisterPageObjects;
import neogrowth.resources.Base;

public class RegisterFormTests extends Base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(RegisterFormTests.class.getName());

	HomePageObjects hp;
	RegisterPageObjects rp;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(config.getProperty("url"));
		log.info("landed on homepage");
	}

	@Test(priority = 1)

	public void clickApplyNow() throws IOException {
		hp = new HomePageObjects(driver);

		hp.clickApplyNow();
		log.info("clicked on apply now");
		hp.switchToFormTab();
		log.info("switched to new tab");

	}

	@Test(priority = 2)
	public void enterFullname() throws Exception {
		rp = new RegisterPageObjects(driver);
		rp.enterFullName("TC_001 EnterFullName");

	}

	@Test(priority = 3)
	public void validateCity() throws IOException {

		rp.validateCityDropdown("TC_002 ValidateCities");
	}

	@Test(priority = 4)
	public void selectCity() throws IOException {

		rp.selectCityfromDropdown("TC_003 SelectCity");
	}

	@Test(priority = 5)
	public void enterInvlaidPhoneNumber() throws IOException {

		rp.enterInvlaidPhoneNumber("TC_004 EnterInvalidPhonenumber");

	}

	@Test(priority = 6)
	public void enterValidPhoneNumber() throws IOException {

		rp.enterValidPhoneNumber("TC_005 EnterValidPhoneNumber");
	}

	@Test(priority = 7)
	public void enterInvlaidEmail() throws IOException {

		rp.enterInvlaidEmail("TC_006 EnterInvalidEmail");

	}

	@Test(priority = 8)
	public void enterValidEmail() throws IOException {

		rp.enterValidEmail("TC_007 EnterValidEmail");
	}

	@Test(priority = 9)
	public void selectBusinessExperience() throws IOException {

		rp.selectBusinessExperience("TC_008 SelectBusinessExperience");
	}

	@Test(priority = 10)
	public void selectAverageMonthlySale() throws IOException {

		rp.selectAverageMonthlySale("TC_009 SelectAverageMonthlySale");
	}

	@Test(priority = 11)
	public void selectBusinessIndustry() throws IOException {

		rp.selectBusinessIndustry("TC_010 SelectBusinessIndustry");
	}

	@Test(priority = 12)
	public void acceptDigitalPayments() throws IOException {

		rp.selectAcceptDigitalPayments("TC_011 AcceptDigitalPayments");
	}

	@Test(dependsOnMethods = { "acceptDigitalPayments" })
	public void selectMonthlyCardDigitalSales() throws IOException {

		rp.selectMonthlyCardDigitalSales("TC_012 Select Monthly Card & Digital Sales");
	}

	@Test(dependsOnMethods = { "acceptDigitalPayments" })
	public void selectpaymentSince() throws IOException {

		rp.selectpaymentSince("TC_013 SelectpaymentSince");
	}

	@Test(priority = 13)
	public void sumit() throws IOException {

		rp.clickOnSubmit();
	}

	@AfterTest
	public void teardown() {

		 driver.quit();

	}

}
