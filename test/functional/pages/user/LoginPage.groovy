package pages.user

/**
 * Created by legaliz_me on 12/8/14.
 */
class LoginPage extends LayoutPage{
    static url = "login/index"

    static at = {
        title ==~ /Login/
    }

    static content = {
        submitLoginButton() { $('input', id: 'submit') }
        errorMessage(required: false) { $('div', class: 'login_message') }

        username { $('input', id: 'username')}
        password { $('input', id: 'password')}
    }

}
