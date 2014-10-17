import socialmusic.Membre
import socialmusic.Musique

class BootStrap {

    def init = { servletContext ->
        def membre1 = new Membre(nom: "Membre 1", motDePasse: "mdp1").save(failOnError: true)
        def membre2 = new Membre(nom: "Membre 2", motDePasse: "mdp2").save(failOnError: true)
        def membre3 = new Membre(nom: "Membre 3", motDePasse: "mdp3").save(failOnError: true)

        def musique1 = new Musique(nom: "Musique 1", artiste: "Artiste 1", album: "Album 1").save(failOnError: true)
        def musique2 = new Musique(nom: "Musique 2", artiste: "Artiste 1", album: "Album 2").save(failOnError: true)
        def musique3 = new Musique(nom: "Musique 3", artiste: "Artiste 2", album: "Album 3").save(failOnError: true)

        membre1.addToMusiques(musique1).save(failOnError: true)

        membre2.addToMusiques(musique1).save(failOnError: true)
        membre2.addToMusiques(musique2).save(failOnError: true)

        membre3.addToMusiques(musique1).save(failOnError: true)
        membre3.addToMusiques(musique2).save(failOnError: true)
        membre3.addToMusiques(musique3).save(failOnError: true)
    }

    def destroy = {
    }
}
