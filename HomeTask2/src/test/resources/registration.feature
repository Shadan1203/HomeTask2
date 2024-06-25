Feature: Registration

  Scenario: Successful registration with valid credentials
    Given the user is on the registration page
    When the user enters valid details
    And the user submits the registration form
    Then the user should be registration successfully

  Scenario: Registration with already registered email
    Given the user is on the registration page
    When the user enters already registered email
    And the user submits the registration form
    Then the user should see error message

  Scenario: Registration with invalid details
    Given the user is on the registration page
    When the user enters invalid details
    And the user submits the registration form
    Then the user should see invalid error message