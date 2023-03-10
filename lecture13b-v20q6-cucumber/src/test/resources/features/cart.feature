Feature: Fruitbasket
  bla bla bla

  Scenario: Two bananas and an apple
    Given I have an empty cart
    When I add a "banana" with the price of 5 kr
    And I add a "banana" with the price of 5 kr
    And I add an "apple" with the price of 6 kr
    Then The number of "banana"s should be 2
    And The total for the "banana"s should be 10
    And The total for the cart should be 16
    
    