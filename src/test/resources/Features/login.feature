Feature: login functionality

  Background:
    Given user should be on login page

  @sanity
  Scenario: valid_login_TC01

    When user enters valid credentials
    And click on login button
    Then user should be navigated to home page
    And user can see the logout link


  @regression
  Scenario: Invalid_login_TC02

    When user enters invalid credentials
    And click on login button
    Then user should be navigated to login page
    And user can see the error message


  @data @sanity @smoke
  Scenario Outline: Invalid_login_with_dataset_TC03

    When user enters invalid credentials username as "<userid>" and password as "<password>"
    And click on login button
    Then user should be navigated to login page
    And user can see the error message

    Examples:
      | userid   | password |
      | admin12  | admin12  |
      | test123  | test123  |
      | user123  | pass123  |
      | demo123  | demo123  |