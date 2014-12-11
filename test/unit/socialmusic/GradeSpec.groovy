package socialmusic

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Grade)
class GradeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "username of user should be unique : #ausername1, #ausername2"() {
        given: "Two users"
        def u1 = new User(username: "ausername1", password: "password1")
        def t1 = new Track(title: "aTitle", artist: "anArtist", album: "anAlbum")
        def grade = new Grade(user:u1,track: t1,grade:agrade)

        when: "User1 then user2 are validated"
        def tostring1 =grade.tostring()


        then: "the results are coherent"
        tostring1 == expected


        where:
        agrade      | expected
        "0" | "duplicateusername"
        "1"                | "1"
        "-1"           | "-1"
    }
}
