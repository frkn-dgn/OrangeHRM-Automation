Feature: OrangeHRM Login

  Scenario: Successful login
    Given user is on the OrangeHRM login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks the login button
    Then user should be logged in successfully

  Scenario: Login with invalid password
    Given user is on the OrangeHRM login page
    When user enters valid username
    And user enters invalid password
    And user clicks the login button
    Then login error message should be displayed

  Scenario: Login with empty credentials
    Given user is on the OrangeHRM login page
    When user clicks the login button
    Then required field messages should be displayed