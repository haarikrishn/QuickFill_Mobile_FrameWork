Feature: invalidSequencPalletOnline:Pick the items in Delivery and load the Delivery into the truck

  @PickingSevenItemsInvalidSequencePalletOnlinev2
  Scenario Outline: pick the Picker1SevenItemsAndLoad invalidSequencePalletType
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItems with InvalidSequencePalletType
    And moving remaining items to pick list with invalidSequencePalletType
    Then verify Items picked or not positiveFlow
    And Logout the user from application

    Examples:
      | username | password   |
#   | 9000680178 | Sweety123@ |
# | 101203   | Dmart@12345 |
      | 121346   | Sweety123@ |


#===================================================================================================================
  @PickerOneDeliveryTwoHUsOnlinev2invalidSequenceBoxType
  Scenario Outline: One Delivery Two HUs invalidSequenceBoxType
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList one HU invalidSequencePalletType
    And user verify the items one By One  and move to pickList Second HU invalidSequencePalletType
    Then verify Items picked or not In Two HUs
    And Logout the user from application
    Examples:
      | username   | password   |
      | 121346   | Sweety123@ |
#    | 9000680178 | Sweety123@ |
#  | 101203   | Dmart@12345 |
##  ===================================================================================================================
  @PickerInvalidQunatityOnlinewithInvalidSequencev2BoxType
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity with invalidSequencePalletType
      | ShortItem        | Short         |
      | DamagedItem      | Damaged       |
      | WrongArticleItem | Wrong article |
    And moving remaining items to pick list for invalid Quantity with invalidSequencePalletType
      | ShortItem        | Short         |
      | DamagedItem      | Damaged       |
      | WrongArticleItem | Wrong article |
    Then verify Items picked or not with invalid Quantity
    And Logout the user from application
    Examples:
      | username   | password   |
      | 121346   | Sweety123@ |
#     | 9000680178 | Sweety123@ |
#      | 101203   | Dmart@12345 |

#
#
#
