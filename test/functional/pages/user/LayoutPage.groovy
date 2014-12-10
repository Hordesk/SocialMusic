package pages.user

import geb.Page

/**
 * Created by legaliz_me on 12/6/14.
 */
class LayoutPage extends Page{

    static content = {
        currentUser(required: false) { $('a', id: 'currentUser') }
        registerButton(to: RegisterPage, required: false) { $('a', href: '/SocialMusic/user/register') }
        loginButton(to: LoginPage, required: false) { $('a', href: '/SocialMusic/login/index') }
        logoutButton(to: HomePage, required: false) { $('a', id: 'logout') }
    }

    boolean isLoggedIn() {
        !registerButton.isPresent() && currentUser.isPresent()
    }
}
