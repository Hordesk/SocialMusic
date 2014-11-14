package socialmusic

import grails.plugin.springsecurity.SpringSecurityService
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
//
////    SpringSecurityService springSecurityService
//
//
//    def setup() {
//        // Workaround for GRAILS-10538
//        service.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
//        def springSecurityService = Mock(SpringSecurityService)
//        springSecurityService.loggedIn >> true
//        User loggedInUser = Mock(User)
//        User user =new User(username:"User",password: "password", id: 1)
//        user.save flush:true
//
//        assert User.count() == 1
//        def userService = Mock(UserService)
//        userService.currentUser >> user
//        springSecurityService.principal >> {id -> 1}
////        springSecurityService.currentUser.username >> "User"
////        springSecurityService.currentUser.password >> "password"
//
//        service.userService = userService
//
//    }
//
//    void "Test the track service correctly persists an instance of track and grade"() {
//        given: "a valid track instance and authentified user"
//
//
//        def track = new Track(title:"titleTest",album:"albumTest",artist:"artistTest")
//
//
//        when:"The save action is executed with a valid instance"
//        service.addTrack(track)
//
//        then:"An instance is created and associated with USER role"
//        service.addTrack(track).class == Grade.class
////        Track.count() == 1
////        Grade.count() == 1
//
//
//    }
}
