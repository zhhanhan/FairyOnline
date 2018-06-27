	/*
	 * Copyright (c) 2012-2013 NetEase, Inc. and other contributors
	 *
	 *  Licensed under the Apache License, Version 2.0 (the "License");
	 *  you may not use this file except in compliance with the License.
	 *  You may obtain a copy of the License at
	 *
	 *      http://www.apache.org/licenses/LICENSE-2.0
	 *
	 *  Unless required by applicable law or agreed to in writing, software
	 *  distributed under the License is distributed on an "AS IS" BASIS,
	 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 *  See the License for the specific language governing permissions and
	 *  limitations under the License.
	 *
	 */
package fairyonline.beforePage;

import java.io.FileInputStream;
import java.util.Properties;

public class Global {


	/**
	 * Global Settings
	 * @author ChenKan
	 */

		public static Properties prop = getProperties();

		public static int browserCoreType = Integer.parseInt(prop.getProperty("BrowserCoreType", "1"));

//		public static String chromeDriverPath = prop.getProperty("ChromeDriverPath", "C:\\Users\\l\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
//		public static String chromeDriverPath = "/Users/chenDoInG/Downloads/chromedriver_for_mac_64";
		public static String firefoxDriverPath = prop.getProperty("webdriver.firfox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		public static String ffDriverPath = prop.getProperty("webdriver.gecko.driver","D:\\Three_up\\lhz\\geckodriver.exe");
		public static String url = ("http://localhost:8032/MyMovie/admin.php");
		public static String stepInterval = prop.getProperty("StepInterval", "500");

		public static String timeout = prop.getProperty("Timeout", "30000");
		
		public static String baseStorageUrl = prop.getProperty("baseStorageUrl", System.getProperty("user.dir"));

		public static String getProperty(String property) {
			return prop.getProperty(property);
		}
		
		public static Properties getProperties() {
			Properties prop = new Properties();
			try {
				FileInputStream file = new FileInputStream("prop.properties");
				prop.load(file);
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return prop;
		}
	}


