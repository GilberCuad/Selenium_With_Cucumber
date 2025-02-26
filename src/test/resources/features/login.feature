Feature: Login on Saucedemo
  Background:
    Given The user browse the page "https://www.saucedemo.com/"

  Scenario: Login with incorrect credentials
    When The user write the username "locked_out_user"
    And The user write the password "secret_sauce" locked
    And The user click on login button
    Then The user verifies error message contains text "Epic sadface: Sorry, this user has been locked out."