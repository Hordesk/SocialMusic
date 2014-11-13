package socialmusic

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
@Mock([User, SecUserSecRole, SecRole])
class UserServiceSpec extends Specification {

    UserService userService

    def setup() {
        userService = new UserService()
        // Workaround for GRAILS-10538
        userService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
    }

    def populateValidParams(params) {
        assert params != null
        params["username"] = 'user2'
        params["password"] = 'mdp2'
    }

    void "Test the register service correctly persists an instance"() {
        given: "a valid user instance"
        new SecRole(authority: 'ROLE_USER').save(flush: true)
        def user = new User(username: "u1", password: "u2")

        when:"The save action is executed with a valid instance"
        userService.registerUser(user)

        then:"An instance is created and associated with USER role"
        User.count() == 1
        SecUserSecRole.count() == 1

        User.first().getAuthorities().size() == 1
        User.first().getAuthorities().first() == SecRole.findByAuthority("ROLE_USER")
    }
}
