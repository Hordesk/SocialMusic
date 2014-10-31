import socialmusic.User

class UserFilters {
    def springSecurityService

    def filters = {
        all(uri:'/**') {
            before = {

            }
            after = { Map model ->
                if (model && springSecurityService.isLoggedIn()) {
                    model['userInstance'] = User.get(springSecurityService.principal.id)
                }
            }
            afterView = { Exception e ->

            }
        }
    }
}
