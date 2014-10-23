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
    void "Name of user should be unique : #aName1, #aName2"() {
        given: "Two users"
        def u1 = new User(name: aName1, password: "password1")
        def u2 = new User(name: aName2, password: "paswword2")

        mockForConstraintsTests(User, [u1])

        when: "User1 then user2 are validated"
        def saved1 = u1.validate()
        def saved2 = u2.validate()

        then: "the results are coherent"
        saved1 == expected1
        saved2 == expected2

        where:
        aName1          | aName2          | expected1 | expected2
        "duplicateName" | "duplicateName" | true      | false
        null            | "goodname"      | false     | true
        "unique1"       | "unique2"       | true      | true
    }

    void "Should enforce name and password not blank constraint"() {
        given: "A User"
        def u1 = new User(name: aName, password: "lol")

        when: "the User is validated"
        def valid = u1.validate()

        then: "the result is coherent"
        valid == expected

        where:
        aName          | aPassword           | expected
        ""             | ""                  | false
        null           | null                | false
        "notBlankName" | "notBlanckPassword" | true
    }
}
