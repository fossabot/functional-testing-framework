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

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.functional.testing.framework.drivers.desktop.Driver;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class WebDriverFactoryTest {

private WebDriver sut;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		//
	}
	
	@Test
	public void shouldBeAbleToInstantiateChromeBrowserUsingWebDriverFactory() {
		sut = WebDriverFactory.getWebDriver(Driver.CHROME);
		assertTrue(sut instanceof ChromeDriver);
	}
	
	@Test
	public void shouldBeAbleToInstantiateEdgeBrowserUsingWebDriverFactory() {
		sut = WebDriverFactory.getWebDriver(Driver.EDGE);
		assertTrue(sut instanceof EdgeDriver);
	}
	
	@Test
	public void shouldBeAbleToInstantiateFirefoxBrowserUsingWebDriverFactory() {
		sut = WebDriverFactory.getWebDriver(Driver.FIREFOX);
		assertTrue(sut instanceof FirefoxDriver);
	}
	
	@Test
	public void shouldBeAbleToInstantiateOperaBrowserUsingWebDriverFactory() {
		sut = WebDriverFactory.getWebDriver(Driver.OPERA);
		assertTrue(sut instanceof OperaDriver);
	}
	
	@Test
	public void shouldBeAbleToInstantiateDefinedBrowserUsingWebDriverFactory() {
		sut = WebDriverFactory.getWebDriver();
		assertTrue(sut instanceof OperaDriver);
	}
	
	@AfterTest
	public void tearDown() {
		sut.quit();
	}
	
}
