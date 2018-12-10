Feature: Testing Quikr Mobile Web Application

  Scenario: Registration flow validation via app(Native)
  As a user i should be able to see my google account when
  i try to register myself with Quikr Application

    Given I launch Quikr App
    When I launch application click continue to proceed to homepage
    And  I choose to login using Google Account
    Then I see my account picker screen with email address "testvagratn@gmail.com"



  Scenario: Registration flow validation via WebApp
  As a user i should be able to choose Facebook when i Register

    Given I launch Quikr mobile web
    When Click Allow to use your device location
    And I Choose to Register
    Then I Should see an option to Register using Facebook

