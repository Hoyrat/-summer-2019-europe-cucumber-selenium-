@login
Feature: Login as an authorized user
  Background:
    Given the user is on the login page

  Scenario: Authorized user should be able to login
    When the user enter the valid credentials
    And the user should be on "Account Summary" page

  Scenario: User with wrong credentials should not be able to login
    When the user tries to login with invalid credentials
    Then the user should see the message "Login and/or password are wrong."
  Scenario: User with blank username or password should not be able to login
    When the user tries to login with no username or password
    Then the user should see the message "Login and/or password are wrong."