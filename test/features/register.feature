@wip
Feature: register new user
  As a music lover
  I can register a new user account
  So the website will remember me

Scenario: new user
  Given I'm not logged in
  And I open the register page
  When I fill in user details "login" "passwd"
  And click Sign-up
  Then I should be redirected to the home page
  And I should see "login" in the user list