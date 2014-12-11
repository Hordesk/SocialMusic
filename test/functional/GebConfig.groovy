/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxBinary

driver = {
    def driverInstance
    def customFirefox = System.getProperty("SocialMusic_firefox_path")
    if(customFirefox) {
        final File firefoxPath = new File(customFirefox)
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath)

        def displayPort = System.getProperty("SocialMusic_display")
        if(displayPort != null)
            firefoxBinary.setEnvironmentProperty("DISPLAY", displayPort)

        driverInstance = new FirefoxDriver(firefoxBinary, null)

    }else{
        driverInstance = new FirefoxDriver()
    }
    driverInstance
}

baseNavigatorWaiting = true
atCheckWaiting = true
