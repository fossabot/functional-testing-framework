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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import qa.functional.testing.framework.exceptions.ElementSynchronizationException;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class SynchronizationElementExists extends Synchronization {

	@Override
	public WebElement synchronizeElement(By by) throws ElementSynchronizationException {
		return (WebElement) performSynchronization(by, ExpectedConditions.presenceOfElementLocated(by));
	}

}
