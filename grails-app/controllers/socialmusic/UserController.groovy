package socialmusic

import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class UserController {

    UserService userService
    TrackService trackService
    GradeService gradeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    def show(User userInstance) {
        respond userInstance
    }

    def register() {
        respond new User(params)
    }

    @Transactional
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'register'
            return
        }

        userService.registerUser(userInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.registered.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }

    //@Secured(['ROLE_USER'])
    def edit(User userInstance) {
        respond userInstance
    }

    @Secured(['ROLE_USER'])
    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }


    def bibliotheque(){
        def grades = trackService.getBibliothequeByUser()
        def test=0
        render(view: "bibliotheque", model:  [grades:grades])
    }

   @Secured(['ROLE_USER'])
    def like(Long id) {
        def trackInstance=Track.findById(id)
        gradeService.like(trackInstance)
        redirect(action: "bibliotheque")
    }

   @Secured(['ROLE_USER'])
    def unlike(Long id) {
        def trackInstance=Track.findById(id)
        gradeService.unlike(trackInstance)
        redirect(action: "bibliotheque")
    }


}
