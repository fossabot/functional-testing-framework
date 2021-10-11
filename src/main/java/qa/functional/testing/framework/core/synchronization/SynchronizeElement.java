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

import qa.functional.testing.framework.core.FrameworkCore;
import qa.functional.testing.framework.exceptions.ElementSynchronizationException;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class SynchronizeElement extends FrameworkCore {

	private static final String SYNCHRONIZATION_FULLY_QUALIFIED_NAME = 
			"qa.functional.testing.framework.core.synchronization.Synchronization%s";
		
	public WebElement synchronizeElement(By by, SynchronizeUsing method) {
		try {
			return ((Synchronization) Class.forName(String.format(SYNCHRONIZATION_FULLY_QUALIFIED_NAME, 
					method.getName())).getDeclaredConstructor().newInstance()).synchronizeElement(by);
		} catch (Exception e) {
			throw new ElementSynchronizationException(
				String.format("Unable to synchronize the element %s using '%s' synchronization implementation", 
					by.toString(), method.getDescription()));
			}
		}
	
}
