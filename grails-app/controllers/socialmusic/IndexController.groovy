package socialmusic

class IndexController {

    def index() {
        render(view:"index.gsp",  model:[userInstanceList: User.list()])

    }
}
