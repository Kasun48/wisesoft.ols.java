Feature: Admin Login functionality

  @Admin
  Scenario: Successful login with valid credentials
    Given Admin user is on the login page
    When Admin user enters credentials
    And Admin user clicks on login button
    Then Admin user should be redirected to the dashboard