Feature: Verify the functionality of Loader with Multiple User for same delivery

  Background: Login to PWP Application and go to Loader Page
    Given Provide username and password to login to application
      | userId   | 101203      |
      | password | Dmart@12345 |
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations

  @Loader1
  Scenario: Perform loading of same delivery by 1st loaders at same time
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9329223868 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Wait for 1 minute
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading

  @Loader2
  Scenario: Perform loading of same delivery by 2nd loaders at same time
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9329223868 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Wait for 2 minute
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that Error Message is displayed while same delivery is loaded by multiple users
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed
