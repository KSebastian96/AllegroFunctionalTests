Feature: Adding to cart

  Scenario: Adding items to cart as non-logged user
    Given User is on main page and privacy policy is accepted
    When User click fashion category
    And User click on subcategory
    And User click watches subcategory
    And User click powystawowe filter
    And User click kup teraz filter
    And User change view
    And User click below 25zł filter
    Then Chosen filter should be visible on page under the category section
    And Ads should match the filters