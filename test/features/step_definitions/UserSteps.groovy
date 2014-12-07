import pages.user.ShowPage
import pages.user.RegisterPage

import static cucumber.api.groovy.EN.*

Given(~/^I'm not logged in$/) { ->
    assert !page.isLoggedIn()
}

Given(~/^I open the register page$/) { ->
    to RegisterPage
    at RegisterPage
}

When(~/^I fill in user details "(.*?)" "(.*?)"$/) { String arg1, String arg2 ->
    $("form").username() << arg1
    $("form").password() << arg2
}

When(~/^click Sign-up$/) { ->
    page.createButton.click()
}

Then(~/^I should be redirected to the "(.*?)" page$/) { String arg1 ->
    switch(arg1) {
        case 'Show':
            at ShowPage
    }
}

Then(~/^User displayed is "(.*?)"$/) { String arg1 ->
    assert page.username.text() == arg1
}
