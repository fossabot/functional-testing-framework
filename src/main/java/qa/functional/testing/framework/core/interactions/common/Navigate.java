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

import java.net.MalformedURLException;
import java.net.URL;

import qa.functional.testing.framework.core.SeleniumCore;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class Navigate extends SeleniumCore {

	public boolean back() {
		try {
			getWebDriver().navigate().back();
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	public boolean forward() {
		try {
			getWebDriver().navigate().forward();
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
	
	public boolean refresh() {
		try {
			getWebDriver().navigate().refresh();
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
	
	public boolean to(String url) {
		try {
			return to(new URL(url));
		} catch (MalformedURLException e) {
			//
		}
		return false;
	}
	
	public boolean to(URL url) {
		try {
			getWebDriver().navigate().to(url);
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
	
}
