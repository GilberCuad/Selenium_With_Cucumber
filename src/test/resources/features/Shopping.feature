Feature: Login and shopping

  Background:
    Given The user browse the page shopping "https://www.saucedemo.com/"
    And The user browse to page shopping


  @verifiesUI
  Scenario: Login with correct credentials
    Then Verifies the page login UI shopping

  @verifyAddProducts
  Scenario:  Add products to car
    When The user add all item to car
    Then The user verify that the shopping cart has number 6 of items added

  @orderItemsZA
  Scenario: Order items to Z -> A
    When The user sort the items descending by name
    And The user waits while the page is being organized
    Then The user verify that the first item be "Test.allTheThings() T-Shirt (Red)" and the last item be "Sauce Labs Backpack"

  @orderItemsPrice
  Scenario: Order items by price to ascend (minor to major)
    When The user sort the items ascend by price
    And The user waits while the page is being organized
    Then The user verify that the price first item be "$7.99" and the last price item be "$49.99"