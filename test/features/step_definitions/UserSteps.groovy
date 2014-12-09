import data.Data
import pages.user.LoginPage
import pages.user.RegisterPage
import pages.user.ShowUserPage
import socialmusic.User

import static cucumber.api.groovy.EN.*

Given(~/^I'm not logged in$/) { ->
    assert !page.isLoggedIn()
}

Given(~/^I open the register page$/) { ->
    to RegisterPage
    at RegisterPage
}

Given(~/^I'm logged in$/) { ->
    assert page.isLoggedIn()
}

Given(~/^I have an account$/) { ->
    def user = new User(Data.users[0])

    if(User.findByUsername(Data.users[0].username) == null) {
        def userService = appCtx.getBean("userService")
        userService.registerUser(user)
    }
}

When(~/^I fill in user details "(.*?)" "(.*?)"$/) { String arg1, String arg2 ->
    page.username = arg1
    page.password = arg2
}

When(~/^click Sign-up$/) { ->
    page.createButton.click()
}

When(~/^I click on "(.*?)" in the menu$/) { String arg1 ->
    switch (arg1) {
        case 'Logout':
            page.logoutButton.click()
            break

        default:
            assert false : "No button of name '" + arg1 + "'"
    }
}

When(~/^I go to the login page$/) { ->
    to LoginPage
}

When(~/^I login with my user details$/) { ->
    page.username = Data.users[0].username
    page.password = Data.users[0].password

    page.submitLoginButton.click()
}

When(~/^I login with incorrect details$/) { ->
    page.username = "gibberish"
    page.password = "wrongpass"

    page.submitLoginButton.click()
}

Then(~/^I should be redirected to the "(.*?)" page$/) { String arg1 ->
    switch(arg1) {
        case 'Show User':
            at ShowUserPage
            break
    }
}

Then(~/^User displayed is "(.*?)"$/) { String arg1 ->
    assert page.username.text() == arg1
}

Then(~/^I should see my profile name in the menu$/) { ->
    assert page.currentUser.text() == Data.users[0].username
}

Then(~/^I should see a Logout button in the menu$/) { ->
    assert page.logoutButton.isPresent()
}

Then(~/^I should see an error message$/) { ->
    at LoginPage
    assert page.errorMessage.isPresent()
}

