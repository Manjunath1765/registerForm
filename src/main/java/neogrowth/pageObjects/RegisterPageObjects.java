package neogrowth.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import neogrowth.resources.DataDriven;

public class RegisterPageObjects {

	public WebDriver driver;

	public RegisterPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	private By fullName = By.xpath("(//input[@id='first_name'])[1]");
	private By phoneNumber = By.xpath("(//input[@id='phone_mobile'])[1]");
	private By phoneNumberError = By.xpath("//em[@id='phone_mobile-error']");
	private By emailError = By.xpath("//em[@id='email1-error']");
	private By city = By.xpath("(//select[@id='primary_address_city'])[1]");

	private By email = By.xpath("(//input[@type='email'])[1]");
	private By businessField = By.xpath("(//select[@id='businesfield'])[1]");
	private By monthlySale = By.xpath("(//select[@id='valuefield'])[1]");
	private By industry = By.xpath("(//select[@id='industry_select'])[1]");
	private By digitalPayment = By.xpath("(//span[@class='checkmark radio_buttons'])[1]");
	private By monthlyCard = By.xpath("(//select[@id='businesfield'])[2]");
	private By paymentSince = By.xpath("(//select[@id='valuefield'])[2]");
	private By submit = By.xpath("(//button[@name='signup'])[1]");

	public void enterFullName(String testCaseName) throws Exception {

		System.out.println(driver.getCurrentUrl());

		driver.findElement(fullName).sendKeys(getExcelData(testCaseName).get(0));

	}

	public static ArrayList<String> getExcelData(String testCaseName) throws IOException {

		DataDriven data = new DataDriven();
		return data.getData(testCaseName);

	}

	public void enterInvlaidPhoneNumber(String testCaseName) throws IOException {
		// TODO Auto-generated method stub

		driver.findElement(phoneNumber).sendKeys(getExcelData(testCaseName).get(0));
		driver.findElement(phoneNumber).sendKeys(Keys.TAB);
		if (driver.findElement(phoneNumberError).isDisplayed()) {
			Assert.assertEquals(getExcelData(testCaseName).get(1), driver.findElement(phoneNumberError).getText());
		} else {
			Assert.assertTrue(false);
		}

	}

	public void enterValidPhoneNumber(String testCaseName) throws IOException {
		// TODO Auto-generated method stub

		driver.findElement(phoneNumber).clear();
		driver.findElement(phoneNumber).sendKeys(getExcelData(testCaseName).get(0));
		driver.findElement(phoneNumber).sendKeys(Keys.TAB);
		if (driver.findElement(phoneNumberError).isDisplayed()) {
			Assert.assertTrue(false);
		}

	}

	public void validateCityDropdown(String testCaseName) throws IOException {

		Select s = new Select(driver.findElement(city));
		List<WebElement> elements = s.getOptions();
		ArrayList<String> actualCities = new ArrayList<String>();
		for (int i = 1; i < elements.size(); i++) {
			actualCities.add(elements.get(i).getText());

		}

		ArrayList<String> expectedCities = getExcelData(testCaseName);

		Assert.assertEquals(actualCities, expectedCities);

	}

	public void selectCityfromDropdown(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		selectDropdown(city, testCaseName);

	}

	public void enterInvlaidEmail(String testCaseName) throws IOException {
		// TODO Auto-generated method stub

		driver.findElement(email).sendKeys(getExcelData(testCaseName).get(0));
		driver.findElement(email).sendKeys(Keys.TAB);
		if (driver.findElement(emailError).isDisplayed()) {
			Assert.assertEquals(getExcelData("TC_006 EnterInvalidEmail").get(1),
					driver.findElement(emailError).getText());
		} else {
			Assert.assertTrue(false);
		}

	}

	public void enterValidEmail(String testCaseName) throws IOException {
		// TODO Auto-generated method stub

		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(getExcelData(testCaseName).get(0));
		driver.findElement(email).sendKeys(Keys.TAB);
		if (driver.findElement(emailError).isDisplayed()) {
			Assert.assertTrue(false);
		}

	}

	public void selectBusinessExperience(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		selectDropdown(businessField, testCaseName);
	}

	public void selectDropdown(By fieldpath, String testCaseName) throws IOException {

		Select s = new Select(driver.findElement(fieldpath));
		s.selectByVisibleText(getExcelData(testCaseName).get(0));

		Assert.assertEquals(s.getFirstSelectedOption().getText(), getExcelData(testCaseName).get(0));

	}

	public void selectAverageMonthlySale(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		selectDropdown(monthlySale, testCaseName);
	}

	public void selectBusinessIndustry(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		selectDropdown(industry, testCaseName);
	}

	public void selectAcceptDigitalPayments(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		if (getExcelData(testCaseName).get(0).equals("Yes")) {
			driver.findElement(digitalPayment).click();

			Assert.assertTrue(driver.findElement(monthlyCard).isDisplayed());
		}
	}

	public void selectMonthlyCardDigitalSales(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		selectDropdown(monthlyCard, testCaseName);
	}

	public void selectpaymentSince(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		selectDropdown(paymentSince, testCaseName);
	}

	public void clickOnSubmit() {
		// TODO Auto-generated method stub
		driver.findElement(submit).click();

	}

}
