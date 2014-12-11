package socialmusic

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED

@Transactional
class TrackService {
    UserService userService

    def addTrack(Track trackInstance) {
        User currentUser = userService.currentUser()
        Grade grade = new Grade(user: currentUser, track: trackInstance, grade: (Integer) 0)
        if (currentUser != null && grade.hasErrors() != true) {
            //Ajouter la track
            trackInstance.save flush: true
            //Ajouter une grade avec une Grade.grade = 0 et Grade.user = currentUser
            grade.save flush: true
        }
    }

    def getBibliothequeByUser() {
        User currentUser = userService.currentUser()
        Grade.findAllByUser(currentUser)
    }

    def getCollectionByUserId(id) {
        Grade.findAllByUser(User.findById(id))
    }

}


