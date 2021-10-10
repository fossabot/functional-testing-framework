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

package qa.functional.testing.framework.drivers.desktop;

import java.net.MalformedURLException;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.functional.testing.framework.properties.FrameworkProperties;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public abstract class Browsers {

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	DesiredCapabilities capabilities;
	
	@Getter(AccessLevel.PROTECTED)
	FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);

	public Browsers() { }
	
	public Browsers(Driver driver) {
		System.setProperty(driver.getProperty(), 
				String.format("%s%s", getFrameworkProperties().getWebDriverPath(), driver.getExecutable()));
	}
	
	public abstract AbstractDriverOptions<?> getOptions();
	public abstract Capabilities toCapabilities();
	public abstract WebDriver getWebDriver() throws MalformedURLException;
	
	protected String getGridHost() {
		return String.format("%s:%s%s", frameworkProperties.getGridUrl(), frameworkProperties.getGridPort(), 
				FrameworkProperties.GRID_HUB_ENDPOINT);
	}
	
}
