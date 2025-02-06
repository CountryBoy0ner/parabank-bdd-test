Feature: Customer Login Form

  Scenario: Verify the Log In button is clickable and responsive
    Given I am on the Customer Login page
    When I click on the Log In button
    Then the button should be clickable and responsive

  Scenario Outline: Verify Username field accepts valid input
    Given I am on the Customer Login page
    When I enter "<username>" in the Username field
    Then the Username field should accept the text

    Examples:
      | username    |
      | testuser1   |
      | testuser2   |
      | admin       |