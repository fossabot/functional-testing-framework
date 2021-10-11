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

package qa.functional.testing.framework.core;

import org.slf4j.LoggerFactory;

/**
 * @author ElisabethQA <92223530+ElisabethQA@users.noreply.github.com>
 */
public class FrameworkVersion {

	private static final String LOGO = // Yeah, I'm that motivated :D
		"Initializing 'qa.functional.testing.framework'...              \n\n" +	
		"                 __                  _   _                   _ \n" +
		"                / _|                | | (_)                 | |\n" +
		"   __ _  __ _  | |_ _   _ _ __   ___| |_ _  ___  _ __   __ _| |\n" +
		"  / _` |/ _` | |  _| | | | '_ \\ / __| __| |/ _ \\| '_ \\ / _` | |\n" +
		" | (_| | (_| | | | | |_| | | | | (__| |_| | (_) | | | | (_| | |\n" +
		"  \\__, |\\__,_| |_|  \\__,_|_| |_|\\___|\\__|_|\\___/|_| |_|\\__,_|_|\n" + 
		"     | | ------------------------------------------------------\n" +
		"     |_| Version %s\n" +
		"  _      -----_---_--------------------------------------------\n" +
		" | |         | | (_)                                           \n" +
		" | |_ ___ ___| |_ _ _ __   __ _                                \n" + 
		" | __/ _ / __| __| | '_ \\ / _` |  A Selenium WebDriver powered \n" +
		" | ||  __\\__ | |_| | | | | (_| |  framework.                    \n" +
		"  \\__\\___|___/\\__|_|_| |_|\\__, |  By Elisabeth Fournier (QA)   \n" +
		"                           __/ |  Copyright 2021\n" +
		"                          |___/  All rights reserved.\n\n" +
	    "Licensed to the Software Freedom Conservancy (SFC)\n" +
		"http://www.apache.org/licenses/LICENSE-2.0 for more information.";
	
	public static void displayLogo() {
		LoggerFactory.getLogger(FrameworkVersion.class).info(String.format(LOGO, "1.0.0-SNAPSHOT"));
	}
	
}
