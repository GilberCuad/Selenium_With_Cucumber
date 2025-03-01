Feature: Login and shopping

  Background:
    Given The user browse the page "https://www.saucedemo.com/"
    And The user browse to page shopping
    And The user click in first element

    Scenario: Verify the back button to products
      When The user click on the button Back to Products
      Then The user verify that back shopping page

      Scenario: Verify details for products
        Then The user verify elements for product