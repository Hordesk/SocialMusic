package pages.user

import geb.Page

class RegisterPage extends LayoutPage{
    static url = "user/register"

    static at = {
        title ==~ /Register/
    }

    static content = {
        createButton(to: ShowPage) { create() }
    }
}
