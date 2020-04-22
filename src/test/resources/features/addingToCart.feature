Feature: Adding to cart

  Scenario Outline: Adding items to cart as non-logged user
    Given User accepted privacy policy and proceed to thermometers subcategory
    When User click random ad
    And Fill amount field with <amount>
    And User click add to cart button
    And User click proceed to cart button
    Then Total price in cart should be correct
    And Price per unit should be correct
    Examples:
      | amount |
      | 5      |
      | 7      |
      | 11     |
      | 3      |