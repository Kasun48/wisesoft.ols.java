Feature: Portal Login functionality

  @Portal
  Scenario: Successful login with valid credentials
    Given Portal user is on the login page
    When Portal user enters credentials
    And Portal user clicks on login button
    Then Portal user should be redirected to the dashboard