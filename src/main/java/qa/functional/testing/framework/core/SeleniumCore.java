package qa.functional.testing.framework.core;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class SeleniumCore {
	
	@Getter
	@Setter(AccessLevel.PRIVATE)
	WebDriverWait wait;
	
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	private ThreadLocal<WebElement> webElement = new ThreadLocal<>();
	private ThreadLocal<List<WebElement>> webElements = new ThreadLocal<>();
	
	public WebDriver getWebDriver() {
		return this.webDriver.get();
	}
	
	public void setWebDriver(WebDriver webDriver) {
		this.webDriver.set(webDriver);
	}
	
	public WebElement getWebElement() {
		return this.webElement.get();
	}
	
	public void setWebElement(WebElement webElement) {
		this.webElement.set(webElement);
	}
	
	public List<WebElement> getWebElements() {
		return this.webElements.get();
	}
	
	public void setWebElements(List<WebElement> webElements) {
		this.webElements.set(webElements);
	}
	
	public void setWebDriverWait(Duration duration) {
		setWait(new WebDriverWait(getWebDriver(), duration));
	}
}
