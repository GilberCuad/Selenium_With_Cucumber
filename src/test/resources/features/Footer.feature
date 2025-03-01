Feature: Footer

  Background:
    Given The user browse the page "https://www.saucedemo.com/"
    And The user browse to page shopping

  Scenario: Verify social network
    Then The user verify that the button is correct with url "https://www.facebook.com/saucelabs" and "https://twitter.com/saucelabs"