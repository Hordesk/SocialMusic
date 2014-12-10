Feature: like or dislike music
  As a music lover
  I can like or dislike a music
  In order to show my appreciation

  Scenario: Like a music increase it's grade
  Given I'm logged in
  And I open the "All Music" page
  And At least one track is listed
  When I like a track
  Then The track grade has increased

  Scenario: Unlike a music decrease it's grade
    Given I'm logged in
    And I open the "All Music" page
    And At least one track is listed
    When I unlike a track
    Then The grade has decreased