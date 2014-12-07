import static cucumber.api.groovy.EN.*

Given(~/^I'm not logged in$/) { ->
    assert false
}
Given(~/^I open the register page$/) { ->
    assert false
}
When(~/^I fill in user details "(.*?)" "(.*?)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    assert false
}
When(~/^click Sign-up$/) { ->
    // Write code here that turns the phrase above into concrete actions
    assert false
}
Then(~/^I should be redirected to the home page$/) { ->
    // Write code here that turns the phrase above into concrete actions
    assert false
}
Then(~/^I should see "(.*?)" in the user list$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    assert false
}
