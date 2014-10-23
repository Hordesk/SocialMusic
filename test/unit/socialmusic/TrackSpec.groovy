package socialmusic

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Track)
class TrackSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Should enforce title, artist, album not blank constraint"() {
        given: "A Track"
        def t1 = new Track(title: aTitle, artist: anArtist, album: anAlbum)

        when: "the track is validated"
        def valid = t1.validate()

        then: "the result is coherent"
        valid == expected

        where:
        aTitle      | anArtist     | anAlbum     | expected
        ""          | ""           | ""          | false
        null        | null         | null        | false
        ""          | "goodArtist" | "goodalbum" | false
        "goodTitle" | ""           | "goodalbum" | false
        "goodTitle" | "goodArtist" | ""          | false
        "goodTitle" | "goodArtist" | "goodalbum" | true
    }
}
