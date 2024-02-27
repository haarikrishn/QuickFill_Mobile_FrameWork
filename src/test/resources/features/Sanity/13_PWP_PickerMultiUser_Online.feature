Feature:multiUser onlline: Verify the functionality of multi users

  @PicingSevenItemsOnlineMultiUser11
  Scenario Outline: pick the Picker1SevenItemsAndLoadBoxAndDispatchType
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When userOne verify the items one By One  and move to PickerSevenItems BoxAndDispatchType in multiUserOne
    Then verify Items picked or not
    And Logout the user from application
    Examples:
      | username   | password   |
#| 9000680178 | Sweety123@ |
#      | 101203   | Dmart@12345 |
      | 121346   | Sweety123@ |

#  =====================================================================
  @PicingSevenItemsOnlineMultiUser12
  Scenario Outline: pick the Picker1SevenItemsAndLoadBoxAndDispatchType
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When userTwo verify the items one By One  and move to PickerSevenItems BoxAndDispatchType in multiUserTwo
    Then verify Items picked or not
    And Logout the user from application
    Examples:
      | username | password    |
#      | 9000680178 | Sweety123@ |
      | 101203   | Dmart@12345 |
#      | 121346   | Sweety123@ |