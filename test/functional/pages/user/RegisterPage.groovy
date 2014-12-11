package pages.user

class RegisterPage extends LayoutPage{
    static url = "user/register"

    static at = {
        title ==~ /S\'enregistrer/
    }

    static content = {
        createButton(to: ShowUserPage) { create() }

        username { $('input', id: 'username')}
        password { $('input', id: 'password')}
    }
}
