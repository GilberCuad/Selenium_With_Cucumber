Feature: Login and shopping

  Background:
    Given The user browse the page shopping "https://www.saucedemo.com/"


  @loginWithIncorrectCredentials
  Scenario: Login with correct credentials
    Then Verifies the page login UI shopping
