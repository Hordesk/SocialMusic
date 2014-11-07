package socialmusic

class Grade {
    User user
    Track track
    Integer grade

    static belongsTo = [track : Track , user : User]

    static constraints = {
    }

}
