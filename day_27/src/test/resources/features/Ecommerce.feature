Feature: E-Commerce End-to-End Workflow

  Background:
    Given User launches browser

  @SmokeTest
  Scenario Outline: Complete e-commerce shopping flow

    When User login using "<rowNumber>"
    And User searches product "<productName>"
    And User applies filter
    And User adds products to cart
    And User removes one product
    Then Validate total amount

    When User proceeds to checkout
    And User proceeds to checkout
    Then Order should be placed successfully

    When User logout successfully

    Examples:
      | rowNumber | productName |
      | 1         | Laptop      |
      | 2         | Mobile      |


  @RegressionTest
  Scenario: Invalid Login Validation

    When User enters invalid username and password
    Then Error message should be displayed


  @SanityTest
  Scenario: Product Search Validation

    When User login using "1"
    And User searches product "Headphone"
    Then Product should be displayed successfully