package socialmusic


import grails.test.mixin.*
import spock.lang.*

@TestFor(GradeController)
@Mock([Grade, Track, User])
class GradeControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        params["user"] = new User(username:'user2',password: 'mdp2')
        params["track"] = new Track(title:'titre',artist: 'artiste',album:'album')

        params["grade"] = 1

    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.gradeInstanceList
        model.gradeInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.gradeInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        def grade = new Grade()
        grade.validate()
        controller.save(grade)

        then: "The create view is rendered again with the correct model"
        model.gradeInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        grade = new Grade(params)

        controller.save(grade)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/grade/show/1'
        controller.flash.message != null
        Grade.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def grade = new Grade(params)
        controller.show(grade)

        then: "A model is populated containing the domain instance"
        model.gradeInstance == grade
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def grade = new Grade(params)
        controller.edit(grade)

        then: "A model is populated containing the domain instance"
        model.gradeInstance == grade
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/grade/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def grade = new Grade()
        grade.validate()
        controller.update(grade)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.gradeInstance == grade

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        grade = new Grade(params).save(flush: true)
        controller.update(grade)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/grade/show/$grade.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/grade/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def grade = new Grade(params).save(flush: true)

        then: "It exists"
        Grade.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(grade)

        then: "The instance is deleted"
        Grade.count() == 0
        response.redirectedUrl == '/grade/index'
        flash.message != null
    }

    void "likeunlike should return all tracks and total grade"() {
        given:""
        User user1 =new User(username:"User",password: "password")
        user1.save(flush : true)
        def track1 = new Track(title: "Die boten", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track1.save(flush: true)
        Grade grade1 = new Grade(user: user1, track: track1, grade: (Integer) 0)
        grade1.save flush: true

        User user2 =new User(username:"Alban",password: "undeux")
        user2.save(flush : true)
        def track2 = new Track(title: "Erwache", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track2.save(flush: true)
        Grade grade2 = new Grade(user: user2, track: track2, grade: (Integer) 1)
        grade2.save flush: true

        when: "likeUnlike is called"
        controller.likeUnlike()

        then: "the page is shown with all tracks"
        view == '/grade/likeUnlike'
        model.tracks == [track1, track2]
    }

    void "should like the track"() {
        given:"A track"
        def track1 = new Track(title: "Die boten", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track1.save(flush: true)

        and:"a grade service"
        def gradeService = Mock(GradeService)
        controller.gradeService = gradeService

        when:"the user likes the track"
        controller.like(track1.id)

        then:"like is called for the track"
        1 * gradeService.like(track1)
    }

    void "should unlike the track"() {
        given:"A track"
        def track1 = new Track(title: "Die boten", artist: "Die Apocalypschen Reiter", album: 'Moral & Wahnsinn')
        track1.save(flush: true)

        and:"a grade service"
        def gradeService = Mock(GradeService)
        controller.gradeService = gradeService

        when:"the user unlikes the track"
        controller.unlike(track1.id)

        then:"like is called for the track"
        1 * gradeService.unlike(track1)
    }
}
