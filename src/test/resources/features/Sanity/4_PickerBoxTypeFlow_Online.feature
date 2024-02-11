Feature: online Box:Pick the items in Delivery and load the Delivery into the truck

  @PickingSevenItemsOnlineBoxv2
  Scenario Outline: pick the Picker1SevenItemsAndLoad
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItems in box type
    And moving remaining items to pick list in box type
    Then verify Items picked or not positiveFlow
#    And Logout the user from application

    Examples:
      | username   | password   |
#    | 9000680178 | Sweety123@ |
      | 121346   | Sweety123@ |
#  | 101203   | Dmart@12345 |

#===================================================================================================================
  @PickerOneDeliveryTwoHUsOnlineBoxv2
  Scenario Outline: One Delivery Two HUs
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList one HU in box type
    And user verify the items one By One  and move to pickList Second HU in box type
    Then verify Items picked or not In Two HUs
#    And Logout the user from application

    Examples:
      | username   | password   |
#   | 9000680178 | Sweety123@ |
      | 121346   | Sweety123@ |
#  | 101203   | Dmart@12345 |
#  ===================================================================================================================
  @PickerInvalidQunatityOnlineBoxv2
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity in box type
      | ShortItem        | Short         |
      | DamagedItem      | Damaged       |
      | WrongArticleItem | Wrong article |
    And moving remaining items to pick list for invalid Quantity in box type
      | ShortItem        | Short         |
      | DamagedItem      | Damaged       |
      | WrongArticleItem | Wrong article |
    Then verify Items picked or not with invalid Quantity
#    And Logout the user from application

    Examples:
      | username   | password   |
#     | 9000680178 | Sweety123@ |
      | 121346   | Sweety123@ |
#      | 101203   | Dmart@12345 |




