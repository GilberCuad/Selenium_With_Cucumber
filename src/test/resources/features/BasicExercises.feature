Feature: Login Saucedemo
  Background:
    Given The user visit the page "https://www.saucedemo.com/"

  Scenario: Exercise One
    When The user get the browser url
    Then The user verifies that the current url is equal to "https://www.saucedemo.com/"


    Scenario: Exercise Two
      And The user visit other page "https://github.com/"
      And The user back page with driver
      When The user get the browser url
      Then The user verifies that the url is "https://www.saucedemo.com/"