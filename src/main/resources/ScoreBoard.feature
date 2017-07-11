@ScoreBoard
Feature: Check score board functionality

  @SelectNFL
  Scenario: I want to check the NFL score board
    Given I open the FoxSports app on a mobile device
     When I click on the score button on top right corner on home page
     Then I select "NFL" from dropdown list
      And I close the driver

   # Then Available videos opens up