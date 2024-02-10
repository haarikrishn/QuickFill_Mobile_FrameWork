Feature: Verify the functionality of multi users

  @PicingSevenItemsMultiUser1
  Scenario Outline: pick the PickingSevenItemsMultiUserOne
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItemsfor Multiusers
    And moving remaining items to pick list for multiUsers
Examples:
  | username   | password   |
#| 9000680178 | Sweety123@ |
    | 101203   | Dmart@12345 |

#  =====================================================================
  @PicingSevenItemsMultiUser2
  Scenario Outline: pick the PickingSevenItemsMultiUserTwo
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItemsfor MultiuserTwo
    And moving remaining items to pick list for multiUserTwo
    Examples:
      | username   | password   |
#      | 9000680178 | Sweety123@ |
|101203   | Dmart@12345 |