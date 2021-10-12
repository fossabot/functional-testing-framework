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

package qa.functional.testing.framework.core.interactions.common.text;

import org.openqa.selenium.By;

import qa.functional.testing.framework.core.SeleniumCore;
import qa.functional.testing.framework.core.synchronization.SynchronizeElement;
import qa.functional.testing.framework.core.synchronization.SynchronizeUsing;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public abstract class Text extends SeleniumCore {

	public boolean clearText(By by) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			getWebElement().clear();
			return true;
		} catch (Exception e) {
			//
		}
		return false;
	}
	
	public String getAttributeValue(By by, String attributeName) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			return getWebElement().getAttribute(attributeName);
		} catch (Exception e) {
			//
		}
		return "";
	}
	
	public String getInnerText(By by) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			return getWebElement().getText();
		} catch (Exception e) {
			//
		}
		return "";
	}
	
	public boolean sendText(By by, CharSequence... text) {
		try {
			setWebElement(new SynchronizeElement().synchronizeElement(by, SynchronizeUsing.ELEMENT_EXISTS));
			getWebElement().sendKeys(text);
			return true;
		} catch (Exception e) {
			
		}
		return true;
	}
	
}
