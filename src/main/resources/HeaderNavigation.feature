@HeaderNavigation
Feature: Check hedaer item navigation

  @Nav
  Scenario: I want to check the navigation of all elements on header
    Given I open the FoxSports app on a mobile device
    When I click on the video tap and go to the video page
    Then I click on back arrow to come back to previous page
    And I close the driver

   # Then Available videos opens up