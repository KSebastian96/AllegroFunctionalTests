Feature: Creating a normal account

  Scenario Outline: Creating a normal account
    Given  Main page opened, cookies accepted
    When User proceed to registration page
    And User fill e-mail field with <e-mail>
    And User fill password field with <password>
    And User enter <day>, <month> and <year> of birth
    And User accept terms of use
    And User click create account button
    Examples:
      | e-mail              | password     | day | month    | year |
      | example@example.com | MałyDuży123@ | 15  | listopad | 1989 |