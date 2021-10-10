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

package qa.functional.testing.framework.drivers.desktop;

import lombok.Getter;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public enum Driver {
	
	CHROME("Chrome", "webdriver.chrome.driver", "chromedriver.exe"),
	EDGE("Edge", "webdriver.edge.driver", "msedgedriver.exe"),
	FIREFOX("Firefox", "webdriver.gecko.driver", "geckodriver.exe"),
	OPERA("Opera", "webdriver.opera.driver", "operadriver.exe");
	
	@Getter
	private String browserName;
	@Getter
	private String property;
	@Getter
	private String executable;
	
	private Driver(String browserName, String property, String executable) {
		this.browserName = browserName;
		this.property = property;
		this.executable = executable;
	}
	
}
