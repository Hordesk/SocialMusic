package socialmusic

import grails.plugin.springsecurity.annotation.Secured

class IndexController {


    def springSecurityService
    def index() {

        render(view:"index.gsp",  model:[userInstanceList: User.list()])

    }

    @Secured(['USER_ROLE'])
    def connectionTest()
    {
        def currentUser=currentUser()
        render "Conected as "+currentUser
    }


    private currentUser(){
        return User.get(springSecurityService.principal.id)
    }
}
