package socialmusic



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ArtisteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Artiste.list(params), model:[artisteInstanceCount: Artiste.count()]
    }

    def show(Artiste artisteInstance) {
        respond artisteInstance
    }

    def create() {
        respond new Artiste(params)
    }

    @Transactional
    def save(Artiste artisteInstance) {
        if (artisteInstance == null) {
            notFound()
            return
        }

        if (artisteInstance.hasErrors()) {
            respond artisteInstance.errors, view:'create'
            return
        }

        artisteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'artiste.label', default: 'Artiste'), artisteInstance.id])
                redirect artisteInstance
            }
            '*' { respond artisteInstance, [status: CREATED] }
        }
    }

    def edit(Artiste artisteInstance) {
        respond artisteInstance
    }

    @Transactional
    def update(Artiste artisteInstance) {
        if (artisteInstance == null) {
            notFound()
            return
        }

        if (artisteInstance.hasErrors()) {
            respond artisteInstance.errors, view:'edit'
            return
        }

        artisteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Artiste.label', default: 'Artiste'), artisteInstance.id])
                redirect artisteInstance
            }
            '*'{ respond artisteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Artiste artisteInstance) {

        if (artisteInstance == null) {
            notFound()
            return
        }

        artisteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Artiste.label', default: 'Artiste'), artisteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'artiste.label', default: 'Artiste'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
