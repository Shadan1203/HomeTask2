Feature: Sign-In/Sign-out

  Scenario: Successful sign-in with valid credentials
    Given the user is on sign-in page
    When the user enters valid credentials
    Then the user should be signed in successfully

  Scenario: Sign-in with invalid credentials
    Given the user is on Login page
    When the user enters invalid credentials
    Then the user should see an error message

  Scenario: Successful sign-out
    Given the user is signed in
    When the user signs out
    Then the user should be signed out successfully