Feature: offline BoxAndDispatchType:Pick the items in Delivery and load the Delivery into the truck

  @PickingSevenItemsOfflineBoxAndDispatchType
  Scenario Outline: pick the Picker1SevenItemsAndLoadBoxAndDispatchType
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItems BoxAndDispatchTypeOffline
    Then verify Items picked or not
    And Logout the user from application

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Load the delivery into the truck in Offline mode and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not for Pallet type dispatch delivery
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed
    And Logout the user from Loader application

    Examples:
      | username | password   |
#   | 9000680178 | Sweety123@ |
 | 101203   | Dmart@12345 |
#      | 121346   | Sweety123@ |


#===================================================================================================================
  @PickerOneDeliveryTwoHUsOfflineBoxAndDispatchType
  Scenario Outline: One Delivery Two HUs
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList one HU BoxAndDispatchTypeOffline
      | ViewHUCount | 4 |
    Then verify Items picked or not
    And Logout the user from application

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Load the delivery into the truck in Offline mode and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not for Pallet type dispatch delivery
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed
    And Logout the user from Loader application

    Examples:
      | username   | password   |
#      | 121346   | Sweety123@ |
#    | 9000680178 | Sweety123@ |
  | 101203   | Dmart@12345 |
#  ===================================================================================================================
  @PickerInvalidQunatityOfflineBoxAndDispatchType
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity BoxAndDispatchTypeOffline
      | ShortItem        | Short         |
      | DamagedItem      | Damaged       |
      | WrongArticleItem | Wrong article |
      | HUFullItem       | HU Full       |
      | PalletFullItem   | Pallet Full   |
    And  user verify the items one By One  and move to pickList without InvalidQuantityOffline
      | ItemName                            | Reason             | RemoveQuantity |
      | Pampers Aloe Baby Wips(72n)         | Short              | 1              |
      | Boroplus Alov Hal Ch Kes Gel(150ml) | Damaged            | 1              |
      | Colgate Maxfresh Blue Gel Tp(300g)  | Wrong article      | 1              |
      | Oral B Kids 2+ Year Toothbrush(3n)  | HuFullOrPalletFull | 1              |
    And  user verify the items one By One  and move to pickList without InvalidQuantity remaining itemsOffline

    Then verify Items picked or not
    And Logout the user from application

#  Pampers Aloe Baby Wips(72n)=========>item0
#  Boroplus Alov Hal Ch Kes Gel(150ml)=========>item1
#  Colgate Maxfresh Blue Gel Tp(300g)=========>item2
#  Oral B Kids 2+ Year Toothbrush(3n)=========>item3
#  Grace Citrus Passi Shower Gel 250ml=========>item4
#  Meadows Air Freshener Lav Bls-240ml=========>item5
#  Grace Deep Impact Shower Gel 250m=========>item6
    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
    And Search the delivery in a Loader Page
    And Verify that vehicle is assigned for a Delivery
    And Verify the dispatch type of a delivery
    And Check the picking progress of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Go to OFFLINE Mode
    And Verify that Loader is in offline mode
    And Load the delivery into the truck in Offline mode and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not for Pallet type dispatch delivery
    And Click on CONFIRM Button in Offline mode
    And Verify that No Network Connection dialouge box is displayed
    And Go to ONLINE mode
    And Confirm the loading
    Then Verify that loading operation is completed
    And Logout the user from Loader application

    Examples:
      | username   | password   |
#      | 121346   | Sweety123@ |
#     | 9000680178 | Sweety123@ |
      | 101203   | Dmart@12345 |




