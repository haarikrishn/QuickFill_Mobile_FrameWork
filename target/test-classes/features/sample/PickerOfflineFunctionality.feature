Feature: Verify the functionality of Picker Module in offline mode

#  @Offline
  Scenario Outline: Pick the items in Offline mode
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItems in offline mode
    Then verify Items picked or not
    And Logout the user from Picker application
    Examples:
      | username | password    |
      | 101203   | Dmart@12345 |