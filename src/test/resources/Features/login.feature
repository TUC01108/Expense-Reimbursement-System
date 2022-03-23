Feature: to test login functionality

  @logintest
  Scenario: check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters username and password
    And user clicks on login button
    Then user is navigated to home page

  @demo
  Scenario: just demo
    Given demo for tags

  @dao
  Scenario: just dao
    Given demo for tags

  @service @controller
  Scenario: just service and controller
    Given demo for tags

  @service
  Scenario: just service
    Given demo for tags

  @controller
  Scenario: just controller
    Given demo for tags
