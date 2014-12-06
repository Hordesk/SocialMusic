import socialmusic.Grade
import socialmusic.SecRole
import socialmusic.SecUser
import socialmusic.SecUserSecRole
import socialmusic.Track
import socialmusic.User

class BootStrap {

    def init = { servletContext ->

        def secUser1 = new User(username: "User", password: "mdp1").save(failOnError: true, flush: true)
        def secUser2 = new User(username: "User2", password: "mdp2").save(failOnError: true, flush: true)

        def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)

        SecUserSecRole.create secUser1, adminRole, true
        SecUserSecRole.create secUser2, userRole, true

        assert User.count() == 2
        assert SecRole.count() == 2
        assert SecUserSecRole.count() == 2


        def track1 = new Track(title:"titre1",artist:"artist1",album:"album1")
        def track2 = new Track(title:"titre2",artist:"artist2",album:"album2")
        def track3 = new Track(title:"titre3",artist:"artist3",album:"album3")


        def grade1 = new Grade(user: secUser1, track: track1, grade:(Integer)0)
        def grade2 = new Grade(user: secUser1, track: track2, grade:(Integer)1)
        def grade3 = new Grade(user: secUser1, track: track3, grade:(Integer)-1)
        def grade4 = new Grade(user: secUser2, track: track2, grade:(Integer)1)

            track1.save flush: true
            grade1.save flush: true
        track2.save flush: true
        grade2.save flush: true
        track3.save flush: true
        grade3.save flush: true
        grade4.save flush: true

    }

    def destroy = {
    }
}
