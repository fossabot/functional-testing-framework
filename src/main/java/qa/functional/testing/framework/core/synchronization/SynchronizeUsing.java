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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public enum SynchronizeUsing {
	
	ELEMENT_CLICKABLE("ElementClickable", "Element to clickable"),
	ELEMENT_EXISTS("ElementExists", "Element exists"),
	FRAME_TO_BE_AVAILABLE("FrameToBeAvailable", "Frame to be available"),
	VISIBILITY_OF_ELEMENT("VisibilityOfElement", "Visibility of the element");
	
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PRIVATE)
	String name;
	
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PRIVATE)
	String description;
	

	private SynchronizeUsing(String name, String description) {
		setName(name);
		setDescription(description);
	}
}

	