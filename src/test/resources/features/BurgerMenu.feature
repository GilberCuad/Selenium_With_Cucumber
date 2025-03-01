Feature: Footer

  Background:
    Given The user browse the page shopping "https://www.saucedemo.com/"
    And The user browse to page shopping
    And The user open burger menu
    And The user waits while open the burger menu

    @smoke
    Scenario: Verify button about
      Then The user verify the button about with url "https://saucelabs.com/"