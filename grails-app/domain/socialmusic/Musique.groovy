package socialmusic

class Musique {

    String nom
    String artiste
    String album

    static hasMany = [membre: Membre]
    static belongsTo = [Membre]

    static constraints = {
        nom(blank: false)
        artiste(blank: false)
        album(blank: false)
    }
}
