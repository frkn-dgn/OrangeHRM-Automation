Feature: Employee Search

  Scenario: Search employee by name
    Given user is on the OrangeHRM login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks the login button
    And user clicks the PIM menu
    And user enters employee name "Ned"
    And user clicks the search button
    Then employee "Ned" should be displayed in the search results


  Scenario: Search for non-existing employee
    Given user is on the OrangeHRM login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks the login button
    And user clicks the PIM menu
    And user enters employee name "XYZ123NonExisting"
    And user clicks the search button
    Then no records found message should be displayed

  Scenario: Add new employee
    Given user is on the OrangeHRM login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks the login button
    And user clicks the PIM menu
    And user clicks the Add Employee menu
    And user enters first name "Aemon"
    And user enters last name "Targeryan"
    And user clicks the save button
    Then employee should be created successfully with first name "Aemon"


  Scenario: Open employee edit page
    Given user is on the OrangeHRM login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks the login button
    And user clicks the PIM menu
    And user enters employee name "Aemon"
    And user clicks the search button
    Then employee "Aemon" should be displayed in the search results
    And user clicks the edit button for "Aemon"
    And user updates first name to "Ned"
    And user clicks the edit save button
    Then employee should be updated successfully