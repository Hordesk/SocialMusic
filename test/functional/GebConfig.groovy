/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver

driver = {
    def driver = new FirefoxDriver()
    driver
}

baseNavigatorWaiting = true
atCheckWaiting = true
