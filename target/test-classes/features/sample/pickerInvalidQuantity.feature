Feature: pick the Items using invalid Qunatity
  @PickerInvalidQunatity
  Scenario Outline: pick the items using Picker Role with invalid Quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity
      | ShortItem   | Short   |
      | DamagedItem | Damaged |
    And moving remaining items to pick list for invalid Quantity
      | ShortItem   | Short   |
      | DamagedItem | Damaged |
    Then verify Items picked or not with invalid Quantity
    Examples:
      | username   | password   |
      | 9000680178 | Sweety123@ |


