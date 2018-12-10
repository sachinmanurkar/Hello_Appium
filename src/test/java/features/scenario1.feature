Feature: Test a scenario under Quikr Mobile App

  Scenario: Search for a use Honda city car in Bangalore city

    Given I launch Quikr App
    When I launch application click continue to proceed to homepage
    Then click on Cancel
    Then Click on the SKIP link on Homepage
    Then Click allow Quikr to access the device location
    Then Tap on Cars category
    And I search for "Honda City" under used cars
    Then I Should see the the first car search result with "Honda"


