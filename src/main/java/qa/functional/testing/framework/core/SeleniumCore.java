// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package qa.functional.testing.framework.core;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.functional.testing.framework.core.interactions.common.Input;
import qa.functional.testing.framework.core.interactions.common.Navigate;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public abstract class SeleniumCore {

	private static ThreadLocal<JavascriptExecutor> javaScriptExecutor = new ThreadLocal<>();
	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	private static ThreadLocal<WebElement> webElement = new ThreadLocal<>();
	private static ThreadLocal<List<WebElement>> webElements = new ThreadLocal<>();

	public void setJavaScriptExecutor(WebDriver webDriver) {
		SeleniumCore.javaScriptExecutor.set((JavascriptExecutor) webDriver);
	}
	
	public JavascriptExecutor getJavaScriptExecutor() {
		return javaScriptExecutor.get();
	}
	
	public void setWait(Duration duration) {
		SeleniumCore.wait.set(new WebDriverWait(getWebDriver(), duration));
	}
	
	public WebDriverWait getWait() {
		return wait.get();
	}

	public WebDriver getWebDriver() {
		return webDriver.get();
	}
	
	public void setWebDriver(WebDriver webDriver) {
		SeleniumCore.webDriver.set(webDriver);
	}
	
	public WebElement getWebElement() {
		return webElement.get();
	}
	
	public void setWebElement(WebElement webElement) {
		SeleniumCore.webElement.set(webElement);
	}
	
	public List<WebElement> getWebElements() {
		return webElements.get();
	}
	
	public void setWebElements(List<WebElement> webElements) {
		SeleniumCore.webElements.set(webElements);
	}
	
	public Input input() {
		return new Input();
	}
	
	public Navigate navigate() {
		return new Navigate();
	}
	
}
