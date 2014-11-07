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

//        user1.addToTracks(track1).save(failOnError: true)
//
//        user2.addToTracks(track1).save(failOnError: true)
//        user2.addToTracks(track2).save(failOnError: true)
//
//        user3.addToTracks(track1).save(failOnError: true)
//        user3.addToTracks(track2).save(failOnError: true)
//        user3.addToTracks(track3).save(failOnError: true)
    }

    def destroy = {
    }
}
