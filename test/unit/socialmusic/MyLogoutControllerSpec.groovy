package socialmusic

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MyLogoutController)

class MyLogoutControllerSpec extends Specification {

    void "test something"() {
        when : "User logout"
        controller.index()

        then : "Redirected on application index"
        response.redirectedUrl == SpringSecurityUtils.securityConfig.logout.filterProcessesUrl
    }
}
