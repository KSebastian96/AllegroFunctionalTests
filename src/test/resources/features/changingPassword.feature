Feature: Changing password at Allegro.pl

  Scenario: Failed changing password
    Given User is logged in
    When User click my account button
    And User click login and password button
    And User click change password button
    And User enter actual password incorrectly
    And User enter new password
    And User confirm new password
    And User click change button
    Then Error message appeared
    And User quit the browser

    Scenario: Successful changing password
      Given User is logged in
      When User click my account button
      And User click login and password button
      And User click change password button
      And User enter actual password correctly
      And User enter new password
      And User confirm new password
      And User click change button
      Then Success message appeared
      And User quit the browser
