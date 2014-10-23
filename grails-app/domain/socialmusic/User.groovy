package socialmusic

class User {
    String name;
    String password;

// will be added later
//    static hasMany = [tracks: Track]

    static constraints = {
        name blank:false, unique: true
    }
}
