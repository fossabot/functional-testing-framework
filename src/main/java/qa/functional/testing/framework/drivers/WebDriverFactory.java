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

package qa.functional.testing.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import qa.functional.testing.framework.drivers.desktop.Browsers;
import qa.functional.testing.framework.drivers.desktop.Driver;
import qa.functional.testing.framework.utilities.testng.TestNgXmlFile;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class WebDriverFactory {

	private static final String WEBDRIVER_FULLY_QUALIFIED_NAME = 
		"qa.functional.testing.framework.drivers.desktop.browsers.%sBrowser";
	
	public static WebDriver getWebDriver() {
		return getWebDriver(TestNgXmlFile.getWebDriver());
	}
	
	public static WebDriver getWebDriver(Driver driver) {
		try {
			return ((Browsers) Class.forName(String.format(WEBDRIVER_FULLY_QUALIFIED_NAME, 
					driver.getBrowserName())).getDeclaredConstructor().newInstance()).getWebDriver();
		} catch (Exception e) {
			throw new WebDriverException(
				String.format("Unable to instantiate %s web driver (grid execution? %s)", 
					driver.getBrowserName(), TestNgXmlFile.isGridExecution()));
		}
	}
	
}
