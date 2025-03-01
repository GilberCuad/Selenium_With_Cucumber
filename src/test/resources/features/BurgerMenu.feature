Feature: Footer

  Background:
    Given The user browse the page "https://www.saucedemo.com/"
    And The user browse to page shopping
    And The user open burger menu

    @smoke
    Scenario: Verify button about
      Then The user verify the button about with url "https://saucelabs.com/"


      Scenario: Logout
        When The user click on the logout button
        Then The user verify which is located on the main page