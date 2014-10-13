package socialmusic

class User {
    String name;

    static constraints = {
        name blank:false, unique: true
    }
}
