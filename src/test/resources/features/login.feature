Feature: Login into account
  Scenario: Failed login
    Given User is on login page
    When User fill username field with correct username
    And User enter incorrect password
    And User click login button
    Then Incorrect password or login message appeared
    And User close the browser

    Scenario: Successful login
      Given User is on login page
      When User fill username field with correct username
      And User enter correct password
      And User click login button
      Then Username should be displayed on main page
      And User close the browser
