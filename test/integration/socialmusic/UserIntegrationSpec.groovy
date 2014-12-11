package socialmusic

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor
import grails.validation.ValidationException
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

/**
 *
 */
@TestFor(User)
class UserIntegrationSpec extends Specification{

    def "test add two users with the same nick"() {
        given: "two users with the same Username"
        def userA = new User(
                username:"username",
                password: "password"
        )

        def userB = new User(
                username:"username",
                password: "password"
        )

        mockForConstraintsTests(User, [userA, userB])

        when: "we add them to the database"
        userA.save(failOnError: true, flush: true)
        userB.save(flush: true)


        then: "saving the second user throw a ValidationException"
        thrown ValidationException
    }


    def "test that update a user password scrambles it before saving it"() {
        given: "a user with a password"
        User User = new User(
                username: "user",
                password: "password",
        )
        User.save(flush: true)

        and: "the spring security service"
        User.springSecurityService = Mock(SpringSecurityService)
        User.springSecurityService.passwordEncoder >> Mock(PasswordEncoder)

        and: "a new password"
        String newPassword = "newPassword"

        when: "updating his password"
        User.password = newPassword
        User.save(flush: true)

        then: "password has been scrambled"
        1 * User.springSecurityService.encodePassword(newPassword)

        when: "updating User without changing the password"
        User.username = "test"
        User.save(flush: true)

        then: "no need to scrambled anything"
        0 * User.springSecurityService.encodePassword(newPassword)
    }
}
