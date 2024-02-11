Feature:multiuserbox: Verify the functionality of multi users

  @PicingSevenItemsMultiUser1BoxType
  Scenario Outline: pick the PickingSevenItemsMultiUserOneInBoxtype
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItemsfor Multiusers In Boxtype
    And moving remaining items to pick list for multiUsers InBoxtype
    Examples:
      | username   | password   |
#| 9000680178 | Sweety123@ |
#    | 101203   | Dmart@12345 |
      | 121346   | Sweety123@ |

#  =====================================================================
  @PicingSevenItemsMultiUser2BoxType
  Scenario Outline: pick the PickingSevenItemsMultiUserTwoInBoxType
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItemsfor MultiuserTwo In Boxtype
    And moving remaining items to pick list for multiUserTwo InBoxtype
    Examples:
      | username | password    |
#      | 9000680178 | Sweety123@ |
#      | 101203   | Dmart@12345
      | 121346   | Sweety123@ |