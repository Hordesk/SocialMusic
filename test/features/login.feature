Feature: login and logout
  As a music lover
  I can login with my account details
  In order to access my music collection

Scenario: Successfull login
  Given I have an account
  When I go to the login page
  And I login with my user details
  Then I should see my profile name in the menu
  And I should see a Logout button in the menu

Scenario: Successfull logout
  Given I'm logged in
  When I click on "Logout" in the menu
  Then I'm not logged in

Scenario: Unsuccessfull login
  Given I have an account
  When I go to the login page
  And I login with incorrect details
  Then I should see an error message
