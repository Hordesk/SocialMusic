package socialmusic

class Track {

    String title
    String artist
    String album



    static hasMany = [grades : Grade]
    static constraints = {
        title(blank: false)
        artist(blank: false)
        album(blank: false)
    }
}
