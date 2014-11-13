package socialmusic

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutHandler

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Secured('permitAll')
class MyLogoutController {

    def index() {
        redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl // '/j_spring_security_logout'
    }
}
