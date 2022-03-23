Feature: to test login functionality of testproject

  @testproject
  Scenario Outline: check login is successful with valid credentials of testproject
    Given new tab is open
    And user is on login page of test project
    When user enters <username> and <password>
    And user clicks on login button of test project
    Then user is navigated to home page of test project

    Examples: |
      | username  | password |
      | 'Tufail'  | '12345'  |
      | 'Daniel'  | '12345'  |
      | 'Richard' | '12345'  |
      | 'Neena'   | '12345'  |
