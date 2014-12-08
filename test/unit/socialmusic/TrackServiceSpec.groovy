package socialmusic

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TrackService)
@Mock([User, Track, Grade])
class TrackServiceSpec extends Specification {

    def setup() {
        // Workaround for GRAILS-10538
        service.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }

        User user =new User(username:"User",password: "password", id: 1)

        def userService = Mock(UserService) {
            currentUser() >> user
        }
        service.userService = userService
    }

    void "Test the track service correctly persists an instance of track and grade"() {

        given: "a valid track instance and authentified user"
        def track = new Track(title:"titleTest",album:"albumTest",artist:"artistTest")

        when:"The save action is executed with a valid instance"
        service.addTrack(track)

        then:"A Track and Grade are created"
        Track.count() == 1
        Grade.count() == 1

        then:"The track has one grade of value 0"
        Track.first().grades.size() == 1
        Track.first().grades.first().grade == 0
    }
}
