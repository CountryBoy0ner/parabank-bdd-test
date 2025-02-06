Feature: Navigation to Registration Form

  Scenario: Navigation to the registration page from the login page
    Given the user is on the Login page
    When the user clicks on the "Register" link
    Then the user should be redirected to the Registration page
    And the registration form should be displayed