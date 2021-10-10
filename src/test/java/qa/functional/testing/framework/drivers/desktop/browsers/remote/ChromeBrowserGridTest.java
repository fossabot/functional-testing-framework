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

package qa.functional.testing.framework.drivers.desktop.browsers.remote;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qa.functional.testing.framework.drivers.desktop.browsers.ChromeBrowser;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class ChromeBrowserGridTest {

	private WebDriver sut;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		sut = new ChromeBrowser().getWebDriver();
	}
	
	@Test
	public void shouldBeAbleToInstantiateChromeBrowserOnTheGrid() {
		assertTrue(sut instanceof RemoteWebDriver);
		sut.navigate().to("https://www.google.ca");
		sut.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
	}
	
	@AfterClass
	public void tearDown() {
		sut.quit();
	}
	
}
