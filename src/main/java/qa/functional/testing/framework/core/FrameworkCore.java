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

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestContext;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.functional.testing.framework.drivers.WebDriverFactory;
import qa.functional.testing.framework.properties.FrameworkProperties;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public abstract class FrameworkCore extends SeleniumCore {
	
	@Getter(AccessLevel.PROTECTED)
	FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);
	
	@Getter
	@Setter(AccessLevel.PRIVATE)
	String testName;
	
	public void setExecutionContext(ITestContext testContext) {
		setTestName(testContext.getName());
		setWebDriver(WebDriverFactory.getWebDriver());
		setWebDriverWait(Duration.ofSeconds(frameworkProperties.getSynchronizationWaitMaximumDuration()));
	}
	
	public void clearExecutionContext() {
		if (getWebDriver() != null) {
			getWebDriver().quit();
		}
	}
}
