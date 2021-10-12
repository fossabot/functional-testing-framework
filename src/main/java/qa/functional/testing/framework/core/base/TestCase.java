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

package qa.functional.testing.framework.core.base;

import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import qa.functional.testing.framework.core.FrameworkCore;
import qa.functional.testing.framework.core.FrameworkVersion;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public abstract class TestCase extends FrameworkCore {

	@BeforeSuite(alwaysRun = true)
	public void initialize() {
		FrameworkVersion.displayLogo();
	}
	
	@BeforeTest(alwaysRun = true)
	public void testSetUp(ITestContext testContext) {
		setExecutionContext(testContext);
	}
	
	@AfterSuite(alwaysRun = false) 
	public void tearDown() {
		clearExecutionContext();
	}
	
	@AfterSuite(alwaysRun = true) 
	public void shutdown() {
		LoggerFactory.getLogger(this.getClass()).info("Shutting down...");
	}
	
	/**
	 * Test case set up
	 * Use this method to prepare the execution of your test case.
	 */
	public abstract void setUp();
	
	/**
	 * Insert your test case into this method
	 */
	public abstract void run();
}
