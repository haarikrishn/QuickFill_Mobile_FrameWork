Feature: Verify the functionality of Loader Module

  Background: Login to PWP Application and go to Loader Page
    Given Provide username and password to login to application
      | userId   | 101203      |
      | password | Dmart@12345 |
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations

#  @load
  Scenario: Load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9174034938 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed
    And Logout the user from Loader application

#  @load
  Scenario: Search Delivery and Load the delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 0062542719 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed
    And Logout the user from Loader application

#  @load
  Scenario: Remove the item from HU and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9303467630 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Adjust the item's caselot in HU
      | itemName      | Grace Deep Impact Shower Gel 250m |
      | removeCaselot | 1                                 |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed

#  @load
  Scenario: Load some of the HUs in the delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9231009156 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide HU number not to be loaded and load the remaining HUs into the truck
      | HU 3000101175 |
      | HU 3000101177 |
    And Confirm the partially loaded HU delivery
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed

##  @load
#  Scenario: Load the Delivery into a truck
#    And Verify that Loader is in Loader Page
#    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
#      | deliveryNumber | 9970654834 |
#    And Verify the dispatch type of a delivery
#    And Click on Delivery Card
#    And Verify that loader is in Delivery Details Page
#    And Load the delivery into the truck
#    And Confirm the loading
#    Then Verify that loading operation is completed
#    And Search the delivery in a Loader Page
#    And Verify that no results found message is displayed

#  @load
  Scenario: Consolidate HUs and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9392058076 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Click on CONSOLIDATE button
    And Provide source HU Number
      | sourceHUNumber | 3000101150 |
    And In Consolidate HU Page click on select all checkbox
    And Click on MOVE button
    And Provide the destination HU number
      | destinationHUNumber | 3000101151 |
    And Verify that Confirm Move Item page is displayed and click on OK button
    And Verify that loader is in Delivery Details Page
    And Verify that HU is empty
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed

#  @load
  Scenario: Load all the Deliveries into trucks
    And Verify that Loader is in Loader Page
    When Load all the deliveries into the truck

#  @BOX
  Scenario: Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9134526805 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX
  Scenario: Give the exception for boxes and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9134805501 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | itemNames                          | exceptionType | damagedBoxes | comments        |
      | Oral B Kids 2+ Year Toothbrush(3n) | Damaged       | 1            |                 |
      | Pampers Aloe Baby Wips(72n)        | Other         | 1            | Item is expired |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX
  Scenario: Give the multiple exceptiona for same items and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9138045415 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | itemNames                          | exceptionType | damagedBoxes | comments |
      | Oral B Kids 2+ Year Toothbrush(3n) | Damaged       | 1            |          |
      | Oral B Kids 2+ Year Toothbrush(3n) | Short         | 1            |          |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX
  Scenario: Give the exception quantity for boxes more than total boxes and check the response
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9208231243 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | itemNames                          | exceptionType | damagedBoxes | comments |
      | Oral B Kids 2+ Year Toothbrush(3n) | Damaged       | 3            |          |
    Then Verify that error message is displayed

#  @BOX
  Scenario: Load the item and give the exception to item
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9208231243 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Search and load the item
      | itemName | Oral B Kids 2+ Year Toothbrush(3n) |
    And Search the item
    And Click on the EXCEPTION button
    Then Verify that Cannot add exception dialouge box is displayed


  #  @load
  Scenario: Remove the item from HU and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9208819307 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Adjust the item's caselot in HU 1
      | itemName                           | removeCaselot |
      | Colgate Maxfresh Blue Gel Tp(300g) | 1             |
      | Grace Deep Impact Shower Gel 250m  | 1             |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed


