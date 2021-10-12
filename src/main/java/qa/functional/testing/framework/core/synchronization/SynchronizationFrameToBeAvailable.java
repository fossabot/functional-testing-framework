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

package qa.functional.testing.framework.core.synchronization;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import qa.functional.testing.framework.exceptions.ElementSynchronizationException;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class SynchronizationFrameToBeAvailable extends Synchronization {

	@Override
	public WebElement synchronizeElement(By by) throws ElementSynchronizationException {
		throw new NotImplementedException();
	}

	@Override
	public WebDriver synchronizeFrame(By by) throws ElementSynchronizationException {
		return (WebDriver) performSynchronization(by, ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	}
}
