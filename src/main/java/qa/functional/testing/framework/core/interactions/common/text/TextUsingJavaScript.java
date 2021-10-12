package qa.functional.testing.framework.core.interactions.common.text;

import org.openqa.selenium.By;

import qa.functional.testing.framework.core.synchronization.SynchronizeElement;
import qa.functional.testing.framework.core.synchronization.SynchronizeUsing;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class TextUsingJavaScript extends Text {

	public boolean clearText(By by) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			getJavaScriptExecutor().
				executeScript("arguments[0].value='';", getWebElement());
			return true;
		} catch (Exception e) {
			//
		}
		return false;
	}
	
	public String getAttributeValue(By by, String attributeName) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			return (String) getJavaScriptExecutor().
					executeScript("arguments[0].getAttribute(arguments[1]);", getWebElement(), attributeName);
		} catch (Exception e) {
			//
		}
		return "";
	}
	
	public String getInnerText(By by) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			return (String) getJavaScriptExecutor().
				executeScript("arguments[0].innerHTML;", getWebElement());
		} catch (Exception e) {
			//
		}
		return "";
	}
	
	public boolean sendText(By by, CharSequence... text) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			getJavaScriptExecutor().executeScript("arguments[0].value=arguments[1];", getWebElement(), text);
			return true;
		} catch (Exception e) {
			
		}
		return true;
	}

}
