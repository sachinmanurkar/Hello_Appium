Feature: Hello world

  Scenario: Computing sum of two number
  As a user When I add two number 12 and 14
  I should see sum 26

    Given I launch iOS App
    And I Choose to enter "12" and "14"
    And I tap on Compute sum
    Then I should see the Result "26"




