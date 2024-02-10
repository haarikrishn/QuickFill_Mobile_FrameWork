Feature: Verify the functionality of Loader Module in offline mode

  Background: Login to PWP Application and go to Loader Page
    Given Provide username and password to login to application
      | userId   | 101203      |
      | password | Dmart@12345 |
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations

#  @Offline
  Scenario: Perform loading operation in Offline mode
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9917391068 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed
#    And Logout the user from Loader application

#  @Offline
  Scenario: Search the Delivery and Perform loading operation in Offline mode
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9130363946 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed

#  @Offline
  Scenario: Remove the item from HU and load the Delivery into a truck in Offline mode
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 940493483 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Adjust the item's caselot in HU
      | itemName      | Colgate Maxfresh Blue Gel Tp(300g) |
      | removeCaselot | 1                                  |
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed

#  @Offline
  Scenario: Search Delivery and Remove the item from HU and load the Delivery into a truck in Offline mode
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9575033540 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Adjust the item's caselot in HU
      | itemName      | Grace Deep Impact Shower Gel 250m |
      | removeCaselot | 1                                  |
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed

#  @Offline
  Scenario: Load some of the HUs in the delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9307945865 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Provide HU number not to be loaded and load the remaining HUs into the truck in Offline mode
      | HU 3000101157 |
      | HU 3000101160 |
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the partially loaded HU delivery
    Then Verify that loading operation is completed

#  @Offline
  Scenario: Search Delivery and Load some of the HUs in the delivery into a truck in Offline mode
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9349284055 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Provide HU number not to be loaded and load the remaining HUs into the truck in Offline mode
      | HU 3000100786 |
      | HU 3000100788  |
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the partially loaded HU delivery
    Then Verify that loading operation is completed

#  @Offline
  Scenario: Consolidate HUs and load the Delivery into a truck in Offline mode
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9272812918 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Click on CONSOLIDATE button
    And Provide source HU Number
      | sourceHUNumber | 3000100599 |
    And In Consolidate HU Page click on select all checkbox
    And Click on MOVE button
    And Provide the destination HU number
      | destinationHUNumber | 3000100597 |
    And Verify that Confirm Move Item page is displayed and click on OK button
    And Verify that loader is in Delivery Details Page
    And Verify that HU is empty
    And Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed

#  @Offline
  Scenario: Search Delivery and Consolidate the HUs and load the Delivery into a truck in Offline mode
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9349284055 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Click on CONSOLIDATE button
    And Provide source HU Number
      | sourceHUNumber | 3000101304 |
    And In Consolidate HU Page click on select all checkbox
    And Click on MOVE button
    And Provide the destination HU number
      | destinationHUNumber | 3000101305 |
    And Verify that Confirm Move Item page is displayed and click on OK button
    And Verify that loader is in Delivery Details Page
    And Verify that HU is empty
    And Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed

#  @BOX_Offline
  Scenario: Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9208231243 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Load the delivery into the truck
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Refresh the page
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

#  @BOX_Offline
  Scenario: Give the exception for boxes and Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9208819307 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Provide the Exceptions for items in a delivery
      | itemNames                          | exceptionType | damagedBoxes | comments        |
      | Oral B Kids 2+ Year Toothbrush(3n) | Damaged       | 1            |                 |
      | Pampers Aloe Baby Wips(72n)        | Other         | 1            | Item is expired |
    And Click on submit button
    And Verify that loader is in Delivery Details Page
    And Load the delivery into the truck
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Refresh the page
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed



