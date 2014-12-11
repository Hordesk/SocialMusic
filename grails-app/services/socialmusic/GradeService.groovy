package socialmusic

import grails.transaction.Transactional

@Transactional
class GradeService {

    UserService userService

    def like(Track track) {
        User currentUser = userService.currentUser()
        def grade= Grade.findByTrackAndUser(track,currentUser)
        if (grade) {
            grade.setGrade(1)
            grade.save flush: true
        } else {
            grade = new Grade(user: currentUser, track: track, grade: (Integer) 1)
            if (currentUser != null && grade.hasErrors() != true) {
                //Ajouter une grade avec une Grade.grade = 1 et Grade.user = currentUser
                grade.save flush: true
            }
        }
    }

    def unlike(Track track) {
        User currentUser = userService.currentUser()
        def grade= Grade.findByTrackAndUser(track,currentUser)
        if (grade) {
            grade.setGrade(-1)
            grade.save flush: true
        } else {
            grade = new Grade(user: currentUser, track: track, grade: (Integer) -1)
            if (currentUser != null && grade.hasErrors() != true) {
                //Ajouter une grade avec une Grade.grade = 1 et Grade.user = currentUser
                grade.save flush: true
            }
        }

    }
}
