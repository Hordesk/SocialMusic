package socialmusic

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import socialmusic.SecRole

@Transactional
class UserService {
    SpringSecurityService springSecurityService

    def currentUser() {
        return (User) User.get(springSecurityService.principal.id);
    }

    def registerUser(User user) {
        user.save flush:true

        def userRole = SecRole.findByAuthority("ROLE_USER")
        assert userRole.authority == "ROLE_USER"

        SecUserSecRole.create user, SecRole.findByAuthority("ROLE_USER"), true
    }
}
