package neogrowth.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

	public WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	private By applyNow = By.xpath("(//a[text()='Apply Now'])[1]");

	private By cookie = By.xpath("(//a[@id='cn-accept-cookie'])[1]");

	private By bannerdot = By.cssSelector("#slick-slide-control00");

	public void clickApplyNow()

	{
		System.out.println(driver.findElement(cookie).isDisplayed());
		if (driver.findElement(cookie).isDisplayed()) {
			driver.findElement(cookie).click();
		}

		driver.findElement(bannerdot).click();

		WebElement apply = driver.findElement(applyNow);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", apply);

	}

	public void switchToFormTab() {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
		}

	}

}
