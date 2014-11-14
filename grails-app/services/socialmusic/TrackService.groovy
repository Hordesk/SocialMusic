package socialmusic

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED

@Transactional
class TrackService {

    def serviceMethod() {

    }

    def addTrack(Track trackInstance)
    {

        SpringSecurityService springSecurityService = new SpringSecurityService();
        User currentUser =(User) User.get(springSecurityService.principal.id)
        TrackService ts=new TrackService();
        // ts.addTrack(trackInstance,currentUser);

        Grade grade = new Grade(user: currentUser, track: trackInstance, grade:(Integer)0)
        if(currentUser!=null && grade.hasErrors()!=true) {
            //Ajouter la track
            trackInstance.save flush: true

            //Ajouter une grade avec une Grade.grade = 0 et Grade.user = currentUser


            grade.save flush: true


        }

        }
    }


