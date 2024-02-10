Feature: Pick the items in Delivery and load the Delivery into the truck In offline Mode

#===================================================================================================================


  @PickerNormalFlowOffline
  Scenario Outline: Pick the items in Offline mode
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItems in offline mode
    Then verify Items picked or not
    And Logout the user from application
    Examples:
      | username | password    |
      | 101203   | Dmart@12345 |
#      | 9000680178 | Sweety123@ |

# ============================================================================================

  @PickerOneDeliveryTwoHUsAndLoadInOfflineMode
 Scenario Outline: One Delivery Two HUs
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList one HU in offline
    Then verify Items picked or not In Two HUs
    And Logout the user from application

   Examples:
      | username   | password   |
#      | 9000680178 | Sweety123@ |
    | 101203   | Dmart@12345 |
#  ===================================================================================================================
  @PickerInvalidQunatityAndLoadInOfflineMode
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity in offline mode
      | ShortItem   | Short   |
      | DamagedItem | Damaged |
    Then verify Items picked or not with invalid Quantity
    And Logout the user from application

    Examples:
      | username   | password   |
#    | 9000680178 | Sweety123@ |
      | 101203   | Dmart@12345 |




