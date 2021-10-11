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

import java.util.function.Function;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.functional.testing.framework.core.FrameworkCore;
import qa.functional.testing.framework.core.FrameworkVersion;
import qa.functional.testing.framework.exceptions.ElementSynchronizationException;
import qa.functional.testing.framework.properties.FrameworkProperties;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public abstract class Synchronization extends FrameworkCore {

	@Getter(AccessLevel.PROTECTED)
	FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);
	
	@Getter(AccessLevel.PUBLIC)
	int synchronizationMaximumAttempts = frameworkProperties.getSynchronizationMaximumAttempts();
	
	@Getter
	@Setter(AccessLevel.PRIVATE)
	String testName;
	
	private ThreadLocal<Integer> synchronizationAttempts = new ThreadLocal<>();
	
	public int getSynchronizationAttempts() {
		return this.synchronizationAttempts.get();
	};
	
	protected void setSynchronizationAttempts(int attempt) {
		this.synchronizationAttempts.set(attempt);
	}
	
	@SuppressWarnings("unchecked")
	protected <V, T> V performSynchronization(By by, ExpectedCondition<T> expectedCondition) 
			throws ElementSynchronizationException {
		for (int i = 0; i < getSynchronizationMaximumAttempts(); i++) {
			try {
				return (V) getWait().until((Function<? super WebDriver, Object>) expectedCondition);
			} catch(TimeoutException e) {
				setSynchronizationAttempts(i + 1);
				LoggerFactory.getLogger(FrameworkVersion.class).info(
					String.format("Unable to synchronize element '%s'. Attempting again " + 
							"(attempt %s of %s - timeout after: %s sec(s))",
						by.toString(),
						getSynchronizationAttempts(),
						getSynchronizationMaximumAttempts(),
						frameworkProperties.getSynchronizationWaitMaximumDuration()
					)
				);
			}
		}
		throw new ElementSynchronizationException(String.format("Unable to find element %s", by));
	}

	public abstract WebElement synchronizeElement(By by) throws ElementSynchronizationException;
}
