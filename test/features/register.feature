Feature: register new user
  As a music lover
  I can register a new user account
  So the website will remember me

Scenario: new user
  Given I open the register page
  And I'm not logged in
  When I fill in user details "Dany" "mypass"
  And click Sign-up
  Then I should be redirected to the "Show User" page
  And User displayed is "Dany"