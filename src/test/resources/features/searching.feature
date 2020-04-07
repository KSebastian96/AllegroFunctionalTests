Feature: searching

  Scenario Outline: Searching for ads as a non-logged user
    Given User is on main page
    When User accept privacy policy
    And User click on searching bar
    And User fill the searching field with <wanted item name>
    And User click search button
    Then Results should contains searched word
    Examples:
      | wanted item name |
      | nóż              |
      | czapka           |
      | rower            |
