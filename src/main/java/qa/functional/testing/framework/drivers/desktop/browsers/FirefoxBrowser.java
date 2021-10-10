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

package qa.functional.testing.framework.drivers.desktop.browsers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import qa.functional.testing.framework.drivers.desktop.Driver;
import qa.functional.testing.framework.drivers.desktop.GeckoBasedBrowsers;
import qa.functional.testing.framework.utilities.testng.TestNgXmlFile;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class FirefoxBrowser extends GeckoBasedBrowsers {

	public FirefoxBrowser() {
		super(Driver.FIREFOX);
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addPreference(PREFERENCE_PRIVATE_BROWSING_AUTOSTART, true);
		return firefoxOptions;
	}

	@Override
	public Capabilities toCapabilities() {
		setCapabilities(new DesiredCapabilities());
		getCapabilities().setCapability(FirefoxOptions.FIREFOX_OPTIONS, getOptions());
		return getCapabilities(); 
	}
	
	@Override
	public WebDriver getWebDriver() throws MalformedURLException {
		WebDriver webDriver = null;
		if (TestNgXmlFile.isGridExecution()) {
			webDriver = new RemoteWebDriver(new URL(getGridHost()), toCapabilities());
		} else {
			webDriver = new FirefoxDriver((FirefoxOptions) getOptions());
		}
		webDriver.manage().window().maximize(); // There's no argument to maximize the browser at launch (like Chrome)
		return webDriver;
	}

}
