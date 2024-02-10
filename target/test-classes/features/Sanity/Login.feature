Feature: Verify the functionality of Login

  @login
  Scenario: Login to PWP application using valid Username and Password
    Given Provide username and password to login to application
      | userId   | 101201      |
      | password | Dmart@12345 |