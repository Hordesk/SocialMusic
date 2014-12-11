package socialmusic

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(GradeService)
@Mock([Track, User, Grade])
class GradeServiceSpec extends Specification {

    def setup() {
        // Workaround for GRAILS-10538
        service.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }

        User user =new User(username:"User",password: "password")
        user.save(flush : true)

        def userService = Mock(UserService) {
            currentUser() >> user
        }
        service.userService = userService
    }

    def cleanup() {
    }

    void "like should increase grade of track"() {
        given: "a track saved by the user"
        def track1 = new Track(title: "Die boten", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track1.save(flush: true)

        Grade grade = new Grade(user: service.userService.currentUser(), track: track1, grade: (Integer) 0)
        grade.save flush: true

        def previousGrade = grade.grade

        when: "I like the track"
        service.like(track1)

        then: "the track grade for the user has increase"
        Grade.find(grade).grade > previousGrade
    }

    void "unlike should decrease grade of track"() {
        given: "a track saved by the user"
        def track1 = new Track(title: "Die boten", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track1.save(flush: true)

        Grade grade = new Grade(user: service.userService.currentUser(), track: track1, grade: (Integer) 0)
        grade.save flush: true

        def previousGrade = grade.grade

        when: "I like the track"
        service.unlike(track1)

        then: "the track grade for the user has increase"
        Grade.find(grade).grade < previousGrade
    }

    void "like track added by another user should add a grade of 1 for it"() {
        given: "a track added by another user"
        User user =new User(username:"Alban",password: "undeux")
        user.save(flush : true)
        def track2 = new Track(title: "Erwache", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track2.save(flush: true)
        Grade grade = new Grade(user: user, track: track2, grade: (Integer) 1)
        grade.save flush: true

        and:"no grade for current user"
        assert Grade.findByUserAndTrack(service.userService.currentUser(), track2) == null

        when:"I like the track"
        service.like(track2)

        then:"a grade of 1 is created"
        assert Grade.findByUserAndTrack(service.userService.currentUser(), track2).grade == 1
    }

    void "unlike track added by another user should add a grade of -1 for it"() {
        given: "a track added by another user"
        User user =new User(username:"Alban",password: "undeux")
        user.save(flush : true)
        def track2 = new Track(title: "Erwache", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track2.save(flush: true)
        Grade grade = new Grade(user: user, track: track2, grade: (Integer) 1)
        grade.save flush: true

        and:"no grade for current user"
        assert Grade.findByUserAndTrack(service.userService.currentUser(), track2) == null

        when:"I like the track"
        service.unlike(track2)

        then:"a grade of 1 is created"
        assert Grade.findByUserAndTrack(service.userService.currentUser(), track2).grade == -1
    }

}
