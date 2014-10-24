import socialmusic.SecRole
import socialmusic.SecUser
import socialmusic.SecUserSecRole
import socialmusic.Track
import socialmusic.Track
import socialmusic.User

class BootStrap {

    def init = { servletContext ->


        def secUser2 = new User(username: "User", password: "mdp1").save(failOnError: true, flush: true)

        def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)

        SecUserSecRole.create secUser2, adminRole, true

        assert User.count() == 1
        assert SecRole.count() == 2
        assert SecUserSecRole.count() == 1


        def track1 = new Track(title: "Track 1", artist: "Artist 1", album: "Album 1").save(failOnError: true)
        def track2 = new Track(title: "Track 2", artist: "Artist 1", album: "Album 2").save(failOnError: true)
        def track3 = new Track(title: "Track 3", artist: "Artist 2", album: "Album 3").save(failOnError: true)

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
