package pages.user

import geb.Page

/**
 * Created by legaliz_me on 12/6/14.
 */
class LayoutPage extends Page{

    static content = {
        currentUser(required: false) { $('a', id: 'currentUser') }
        registerButton(to: RegisterPage, required: false) { $('a', href: '/SocialMusic/user/register') }
    }

    boolean isLoggedIn() {
        !registerButton.isPresent() && currentUser.isPresent()
    }
}
