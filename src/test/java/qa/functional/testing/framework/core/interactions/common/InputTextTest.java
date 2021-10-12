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

package qa.functional.testing.framework.core.interactions.common;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import qa.functional.testing.framework.core.base.TestCase;
import qa.functional.testing.framework.core.synchronization.SynchronizeElement;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class InputTextTest extends TestCase {

	@Override
	public void setUp() { } // Will be used later

	@Override
	public void run() { } // Will be used later

	@Test
	public void shouldBeAbleToSendText() {
		String valueToSend = "Elisabeth";
		navigate().to("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_input");
		setWebDriver(new SynchronizeElement().synchronizeFrame(By.id("iframeResult")));
		/* Selenium implementation */
		assertTrue(input().text().sendText(By.id("fname"), valueToSend));
		assertEquals(input().text().getAttributeValue(By.id("fname"), "value"), valueToSend);
		assertTrue(input().text().clearText(By.id("fname")));
		assertEquals(input().text().getAttributeValue(By.id("fname"), "value"), "");
		/* JavaScript implementation */
		assertTrue(input().text(Using.JAVASCRIPT).sendText(By.id("fname"), valueToSend));
		assertEquals(input().text(Using.JAVASCRIPT).getAttributeValue(By.id("fname"), "value"), valueToSend);
		assertTrue(input().text(Using.JAVASCRIPT).clearText(By.id("fname")));
		assertEquals(input().text(Using.JAVASCRIPT).getAttributeValue(By.id("fname"), "value"), "");
	}
	
}
