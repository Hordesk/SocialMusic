package socialmusic



import grails.test.mixin.*
import spock.lang.*

@TestFor(UserController)
@Mock([User, SecUserSecRole, UserService])
class UserControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        params["username"] = 'user2'
        params["password"] = 'mdp2'
        params["id"] = 1
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.userInstanceList
            model.userInstanceCount == 0
    }

    void "Test the register action returns the correct model"() {
        when:"The register action is executed"
        controller.register()

        then:"The model is correctly created"
        model.userInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        setup:
        def userService = Mock(UserService)
        controller.userService = userService

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        def user = new User()
        user.validate()
        controller.save(user)

        then:"The register view is rendered again with the correct model"
        model.userInstance!= null
        view == 'register'

        when:"The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        user = new User(params)
        mockDomain(User, [user])

        controller.save(user)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/user/show/1'
        controller.flash.message != null

        1 * userService.registerUser(_ as User)
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def user = new User(params)
            controller.show(user)

        then:"A model is populated containing the domain instance"
            model.userInstance == user
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def user = new User(params)
            controller.edit(user)

        then:"A model is populated containing the domain instance"
            model.userInstance == user
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/user/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def user = new User()
            user.validate()
            controller.update(user)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.userInstance == user

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            user = new User(params).save(flush: true)
            controller.update(user)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/user/show/$user.id"
            flash.message != null
    }
}
