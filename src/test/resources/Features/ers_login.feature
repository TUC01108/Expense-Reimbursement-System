Feature: to test login functionality of ersproject
  @ersproject
  Scenario Outline: check login is successful with valid credentials of ERS
    Given new tab is open
    And user is on login page of ERS project
    When user enters <username> and <password>
    And user clicks on login button of ERS project
    Then user is navigated to home page of ERS project

    Examples: |
      | username  | password |
      | 'test'  | 'root123'  |
      | 'manager4'  | 'rootroot'  |
      | 'test1' | 'root123'  |
      | 'test3'   | 'root123'  |
