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

package qa.functional.testing.framework.utilities.testng;

import org.aeonbits.owner.ConfigFactory;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.functional.testing.framework.drivers.desktop.Driver;
import qa.functional.testing.framework.properties.FrameworkProperties;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class TestNgXmlFile {

	static FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);
	
	/**
	 * Is fallback to default values (i.e, unable to fetch required value from TestNg file)
	 * True: values overridden by default values coming from .properties or DefaultValue annotations
	 * False: values coming from the current TestNg XML file
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	static boolean fallbackDefaultValues;
	
	@Getter
	@Setter(AccessLevel.PRIVATE)
	static XmlTest xmlTest;
	
	static {
		xmlTest = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
	}
	
	private static String toStringParameterValue(String parameterKey, String fallbackValue, boolean toUpperCase) {
		try {
  			return toUpperCase ? xmlTest.getParameter(parameterKey).toUpperCase() : xmlTest.getParameter(parameterKey);
		} catch(NullPointerException e) {
			/* The fallback value will be used if we cannot invoke XmlTest.getParameter(String) */
			setFallbackDefaultValues(true);
			return toUpperCase ? fallbackValue.toUpperCase() : fallbackValue;
		}
	}
	
	private static boolean toBooleanParameterValue(String parameterKey, boolean fallbackValue) {
		try {
			return Boolean.valueOf(xmlTest.getParameter(parameterKey));
		} catch(NullPointerException e) {
			setFallbackDefaultValues(true);
			return fallbackValue;
		}
	}
	
	public static boolean isGridExecution() {
		return toBooleanParameterValue(TestNgParameters.GRID_EXECUTION, 
			frameworkProperties.isWebDriverGridExecutionDefault());
	}
		
	public static Driver getWebDriver() {
		return Driver.valueOf(toStringParameterValue(TestNgParameters.WEBDRIVER, 
			frameworkProperties.getWebDriverDefault().toString(), true)
		);
	}
}
