Feature: Main Page Navigation and Functional Verification

  Scenario: Verify main page navigation and functionality
    Given I am on the main page
    When I click on the "About Us" link
    Then I should be navigated to the about page

    When I click on the "www.parasoft.com" link
    Then I should be navigated to the Parasoft website
    When I click the browser back button
    Then I should be navigated back to the about page

    When I click on the logo
    Then I should be navigated to the home page
    And I should see the element with class "services"

    When I click on the "Admin Page" link
    Then I should be navigated to the admin page
    When I scroll down until the submit button is visible
    And I click on the submit button
    Then I should see the message "Settings saved successfully."
    When I click on the submit button
    Then I should see the message "Settings saved successfully."
    When I click on the logo
    Then I should be navigated to the home page
    And I should see the element with class "services"
