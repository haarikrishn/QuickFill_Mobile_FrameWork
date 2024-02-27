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
      | deliveryNumber | 945820285 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
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
      | deliveryNumber | 9170530516 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed
    And Logout the user from Loader application

#  @load
#  Scenario: Remove the item from HU and load the Delivery into a truck
#    And Verify that Loader is in Loader Page
#    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
#      | deliveryNumber | 9275583787 |
#    And Search the delivery in a Loader Page
#    And Verify that vehicle is assigned for a Delivery
#    And Verify the dispatch type of a delivery
#    And Check the picking progress of a delivery
#    And Click on Delivery Card
#    And Verify that loader is in Delivery Details Page
#    And Adjust the item's caselot in HU
#      | itemName      | Grace Deep Impact Shower Gel 250m |
#      | removeCaselot | 1                                 |
#    And Verify that loader is in Delivery Details Page
#    And Load the delivery into the truck
#    And Confirm the loading
#    Then Verify that loading operation is completed
#    And Search the delivery in a Loader Page
#    And Verify that no results found message is displayed

#  @load
  Scenario: Load some of the HUs in the delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9238590198 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide HU number not to be loaded and load the remaining HUs into the truck
      | HU 3000101927 |
      | HU 3000101929 |
    And Confirm the partially loaded HU delivery
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed

#  @load
  Scenario: Consolidate HUs and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 94786116 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Click on CONSOLIDATE button
    And Provide source HU Number
      | sourceHUNumber | 3000101975 |
    And In Consolidate HU Page click on select all checkbox
    And Click on MOVE button
    And Provide the destination HU number
      | destinationHUNumber | 3000101977 |
    And Verify that Confirm Move Item page is displayed and click on OK button
    And Verify that loader is in Delivery Details Page
    And Verify that HU is empty
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed

#  @load
#  Scenario: Load all the Deliveries into trucks
#    And Verify that Loader is in Loader Page
#    When Load all the deliveries into the truck

#  @load
  Scenario: Load the delivery while picking is still in progress
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9921595649 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Click on CONFIRM Button
    Then Verify that Cannot confirm delivery dialouge box is displayed

#  @BOX
  Scenario: Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9518720881 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed
    And Logout the user from Loader application

#  @BOX
  Scenario: Adjust the boxes quantity from loaded item and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9172429428 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Adjust the boxes quantity in loaded item
      | itemNames                         | actions             | boxesQuantityAdjustment |
      | Grace Deep Impact Shower Gel 250m | removeBoxesQuantity | 2                       |
      | Grace Deep Impact Shower Gel 250m | addBoxesQuantity    | 2                       |
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX
  Scenario: Adjust the boxes quantity from loaded item and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9198994658 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Adjust the boxes quantity in loaded item
      | itemNames                          | actions             | boxesQuantityAdjustment |
      | Oral B Kids 2+ Year Toothbrush(3n) | removeBoxesQuantity | 1                       |
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX
  Scenario: Give the exception for boxes and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9203507340 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | itemNames                          | exceptionType | damagedBoxes | comments        |
      | Oral B Kids 2+ Year Toothbrush(3n) | Damaged       | 1            |                 |
      | Grace Deep Impact Shower Gel 250m  | Other         | 1            | Item is expired |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX
  Scenario: Search items using EAN and Give the exception for boxes and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9292384503 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | ean           | exceptionType | damagedBoxes | comments        |
      | 8901314524010 | Damaged       | 1            |                 |
      | 8901248154031 | Other         | 1            | Item is expired |
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
      | deliveryNumber | 9257834754 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | itemNames                           | exceptionType | damagedBoxes | comments |
      | Grace Citrus Passi Shower Gel 250ml | Damaged       | 1            |          |
      | Grace Citrus Passi Shower Gel 250ml | Short         | 1            |          |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Verify the loaded boxes quantity
    And Verify the loaded article quantity
    And Verify the Box Exception quantity
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX
  Scenario: Search items using EAN and Give the exception for boxes and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 932400728 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | ean           | exceptionType | damagedBoxes | comments        |
      | 8903363007247 | Damaged       | 1            |                 |
      | 8903363007247 | Short         | 1            | Item is expired |
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
      | deliveryNumber | 9456610818 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | itemNames                           | exceptionType | damagedBoxes | comments |
      | Grace Citrus Passi Shower Gel 250ml | Damaged       | 3            |          |
    Then Verify that error message is displayed

#  @BOX
  Scenario: Load the item and give the exception to item
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9456610818 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Search and load the item
      | itemName | Grace Citrus Passi Shower Gel 250ml |
    And Search the item
    And Click on the EXCEPTION button
    Then Verify that Cannot add exception dialouge box is displayed

#  @BOX
  Scenario: Load the items without assigning vehicle to a delivery
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9771060626 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    Then Verify that vehicle has not assigned for this delivery dialouge box is displayed

  @BOX
  Scenario: Confirm delivery loading without loading any item
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9456610818 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Click on CONFIRM Button
    Then Verify that Cannot confirm delivery dialouge box is displayed

  @load
  Scenario: Remove the item's caselot quantity from HU and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9105480583 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Adjust the item's caselot in HU 1
      | itemName                           | removeCaselot |
      | Oral B Kids 2+ Year Toothbrush(3n) | 1             |
      | Grace Deep Impact Shower Gel 250m  | 1             |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed

#  @load
  Scenario: Remove the item's caselot quantity from HU and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9467326913 |
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Adjust the item's caselot in HU 1
      | itemName                            | removeCaselot |
      | Pampers Aloe Baby Wips(72n)         | 1             |
      | Oral B Kids 2+ Year Toothbrush(3n)  | 1             |
      | Grace Citrus Passi Shower Gel 250ml | 1             |
      | Grace Deep Impact Shower Gel 250m   | 1             |
      | Meadows Air Freshener Lav Bls-240ml | 1             |
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Search the delivery in a Loader Page
    And Verify that no results found message is displayed


