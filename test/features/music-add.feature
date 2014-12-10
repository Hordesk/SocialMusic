Feature: add a music to my library
  As a music lover
  I can add a music to my library
  In order to collect the music I listen to

  Scenario: Add a new music
  Given I'm logged in
  When I add a new track
  Then I should see the track in my collection