package socialmusic

class Track {

    String title
    String artist
    String album

    // Will be added in later
//    static hasMany = [users: User]
//    static belongsTo = [Track]

    static constraints = {
        title(blank: false)
        artist(blank: false)
        album(blank: false)
    }
}
