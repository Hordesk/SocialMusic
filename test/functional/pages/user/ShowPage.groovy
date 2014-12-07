package pages.user

/**
 * Created by legaliz_me on 12/6/14.
 */
class ShowPage extends LayoutPage{
    static at = {
        title ==~ /Show User/
    }

    static content = {
        username { $('span', "aria-labelledby": 'username-label') }
    }
}
