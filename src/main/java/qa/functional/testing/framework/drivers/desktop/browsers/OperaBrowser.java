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
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import qa.functional.testing.framework.drivers.desktop.ChromiumBasedBrowsers;
import qa.functional.testing.framework.drivers.desktop.Driver;
import qa.functional.testing.framework.utilities.testng.TestNgXmlFile;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class OperaBrowser extends ChromiumBasedBrowsers {

	public OperaBrowser() {
		super(Driver.OPERA);
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		OperaOptions operaOptions = new OperaOptions();
		operaOptions.addArguments(ARGUMENT_START_MAXIMIZED);
		operaOptions.addArguments(ARGUMENT_INPRIVATE_MODE);
		return operaOptions;
	}
	
	@Override
	public Capabilities toCapabilities() {
		setCapabilities(new DesiredCapabilities());
		getCapabilities().setCapability(OperaOptions.CAPABILITY, getOptions());
		return getCapabilities(); 
	}

	@Override
	public WebDriver getWebDriver() throws MalformedURLException {
		if (TestNgXmlFile.isGridExecution()) {
			return new RemoteWebDriver(new URL(getGridHost()), toCapabilities());
		}
		return new OperaDriver((OperaOptions) getOptions());
	}
	
}
