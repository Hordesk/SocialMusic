import socialmusic.Track
import socialmusic.Track
import socialmusic.User

class BootStrap {

    def init = { servletContext ->
        def user1 = new User(name: "User 1", password: "mdp1").save(failOnError: true)
        def user2 = new User(name: "User 2", password: "mdp2").save(failOnError: true)
        def user3 = new User(name: "User 3", password: "mdp3").save(failOnError: true)

        def track1 = new Track(title: "Track 1", artist: "Artiste 1", album: "Album 1").save(failOnError: true)
        def track2 = new Track(title: "Track 2", artist: "Artiste 1", album: "Album 2").save(failOnError: true)
        def track3 = new Track(title: "Track 3", artist: "Artiste 2", album: "Album 3").save(failOnError: true)

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
