package socialmusic

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    @Unroll
    void "username of user should be unique : #ausername1, #ausername2"() {
        given: "Two users"
        def u1 = new User(username: ausername1, password: "password1")
        def u2 = new User(username: ausername2, password: "paswword2")

        mockForConstraintsTests(User, [u1])

        when: "User1 then user2 are validated"
        def saved1 = u1.validate()
        def saved2 = u2.validate()

        then: "the results are coherent"
        saved1 == expected1
        saved2 == expected2

        where:
        ausername1      | ausername2          | expected1 | expected2
        "duplicateusername" | "duplicateusername" | true      | false
        null                | "goodusername"      | false     | true
        "unique1"           | "unique2"           | true      | true
    }

    void "Should enforce username and password not blank constraint"() {
        given: "A User"
        def u1 = new User(username: ausername, password: aPassword)

        when: "the User is validated"
        def valid = u1.validate()

        then: "the result is coherent"
        valid == expected

        where:
        ausername          | aPassword           | expected
        ""                 | ""                  | false
        null               | null                | false
        "notBlankusername" | "notBlanckPassword" | true
    }
}
