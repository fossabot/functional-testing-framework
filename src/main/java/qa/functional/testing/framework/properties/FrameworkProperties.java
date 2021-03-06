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

package qa.functional.testing.framework.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

import qa.functional.testing.framework.drivers.desktop.Driver;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
@Sources({ "classpath:framework.properties" })
public interface FrameworkProperties extends Config {

	static final String GRID_HUB_ENDPOINT = "/wd/hub";
	
	@Key("grid.execution.default")
	@DefaultValue("false")
	boolean isGridExecutionDefault();
	
	@Key("synchronization.maximum.attempts")
	@DefaultValue("3")
	int getSynchronizationMaximumAttempts();
	
	@Key("synchronization.wait.maximum.duration")
	@DefaultValue("15")
	int getSynchronizationWaitMaximumDuration();
	
	@Key("webdriver.grid.url")
	@DefaultValue("http://localhost")
	String getGridUrl();
		
	@Key("webdriver.grid.port")
	@DefaultValue("4444")
	String getGridPort();
	
	@Key("webdriver.default")
	@DefaultValue("CHROME")
	Driver getWebDriverDefault();
	
	@Key("webdriver.path")
	@DefaultValue("")
	String getWebDriverPath();
	
}
