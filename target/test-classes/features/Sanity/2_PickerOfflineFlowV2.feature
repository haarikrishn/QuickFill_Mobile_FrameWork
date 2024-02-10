Feature: Pick the items in Delivery and load the Delivery into the truck In offline Mode

#===================================================================================================================


  @PickerNormalFlowOfflinev2
  Scenario Outline: Pick the items in Offline mode
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItems in offline mode
    Then verify Items picked or not
    And Logout the user from application
    #  @Offline

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
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
    And Logout the user from Loader application


    Examples:
      | username | password    |
      | 101203   | Dmart@12345 |
#      | 9000680178 | Sweety123@ |

# ============================================================================================

  @PickerOneDeliveryTwoHUsAndLoadInOfflineModev2
 Scenario Outline: One Delivery Two HUs
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList one HU in offline
    Then verify Items picked or not In Two HUs
    And Logout the user from application

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
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
    And Logout the user from Loader application

   Examples:
     | username   | password   |
#     | 9000680178 | Sweety123@ |
   | 101203   | Dmart@12345 |
#  ===================================================================================================================
  @PickerInvalidQunatityAndLoadInOfflineModev2
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity in offline mode
      | ShortItem        | Short         |
      | DamagedItem      | Damaged       |
      | WrongArticleItem | Wrong article |
    Then verify Items picked or not with invalid Quantity
    And Logout the user from application

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
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
    And Logout the user from Loader application

    Examples:
      | username   | password   |
#    | 9000680178 | Sweety123@ |
     | 101203   | Dmart@12345 |




