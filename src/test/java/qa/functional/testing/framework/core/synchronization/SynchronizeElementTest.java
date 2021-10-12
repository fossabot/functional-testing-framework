package qa.functional.testing.framework.core.synchronization;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import qa.functional.testing.framework.core.base.TestCase;
import qa.functional.testing.framework.exceptions.ElementSynchronizationException;

public class SynchronizeElementTest extends TestCase {

	@Override
	public void setUp() { } // Will be used later

	@Override
	public void run() { } // Will be used later
	
	@Test
	public void shouldBeAbleToSynchronizeElements() {
		getWebDriver().navigate().to("https://www.google.ca");
		getWebDriver().findElement(By.name("q")).sendKeys("download selenium" + Keys.ENTER);
		assertTrue(
			new SynchronizeElement().synchronizeElement(By.id("result-stats"), 
				SynchronizeUsing.VISIBILITY_OF_ELEMENT) instanceof WebElement);
		setWebElements(getWebDriver().findElements(By.tagName("a")));
		assertTrue(
			new SynchronizeElement().synchronizeElement(By.xpath("(//a)[1]"), 
				SynchronizeUsing.ELEMENT_EXISTS) instanceof WebElement);
		assertTrue(
			new SynchronizeElement().synchronizeElement(By.xpath("(//a)[1]"), 
				SynchronizeUsing.ELEMENT_CLICKABLE) instanceof WebElement);
		assertTrue(getWebElements().size() > 1);
	}
	
	 @Test(expectedExceptions = { ElementSynchronizationException.class })
	 public void shouldThrowElementSynchronizationException() {
		getWebDriver().navigate().to("https://www.google.ca");
		new SynchronizeElement().synchronizeElement(By.id("non-existing-element-for-the-sake-of-the-test"), 
			SynchronizeUsing.VISIBILITY_OF_ELEMENT);
	 }

}
