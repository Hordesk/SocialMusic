/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxBinary


driver = {
    final File firefoxPath = new File(System.getProperty("MYAPP.firefox.path", "/usr/bin/firefox"))
    FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath)
    firefoxBinary.setEnvironmentProperty("DISPLAY", ":99.0")
    driverInstance = new FirefoxDriver(firefoxBinary, null)
    def driver = new FirefoxDriver()
    driver
}

baseNavigatorWaiting = true
atCheckWaiting = true
