package socialmusic

class Membre {

    String nom
    String motDePasse

    static hasMany = [musiques: Musique]

    static constraints = {
        nom(blank: false, unique: true)
        motDePasse(blank: false)
    }
}
