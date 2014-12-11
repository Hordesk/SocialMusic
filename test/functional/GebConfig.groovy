/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxBinary

driver = {
    def driverInstance
    def displayPort = System.getProperty("SocialMusic_display")
    if(displayPort) {
        final File firefoxPath = new File("which firefox".execute().text)
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath)
        firefoxBinary.setEnvironmentProperty("DISPLAY", displayPort)

        driverInstance = new FirefoxDriver(firefoxBinary, null)

    }else{
        driverInstance = new FirefoxDriver()
    }
    driverInstance
}

baseNavigatorWaiting = true
atCheckWaiting = true
