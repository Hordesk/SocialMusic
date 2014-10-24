package socialmusic

import grails.plugin.springsecurity.annotation.Secured

class IndexController {

    def index() {
        render(view:"index.gsp",  model:[userInstanceList: User.list()])

    }
}
