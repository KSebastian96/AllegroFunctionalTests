Feature: searching

  Scenario Outline: Searching for ads as a non-logged user
    Given User is on main page and accept privacy policy
    When User click on searching bar
    And User fill the searching field with <wanted item name>
    And User click search button
    Then Results should contains searched word
    And Searched word should be visible on the top of page
    And Result page should contains 64 ads
    Examples:
      | wanted item name |
      | nóż              |
      | czapka           |
      | rower            |
