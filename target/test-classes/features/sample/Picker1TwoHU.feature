Feature: pick the Items for One Delivery Number Two HUs
  @PickerOneDeliveryTwoHUs
  Scenario Outline: One Delivery Two HUs
    Given Enter username "<username>" and password "<password>" to login to the picker application
   When user verify the items one By One  and move to pickList one HU
  And user verify the items one By One  and move to pickList Second HU
Then verify Items picked or not In Two HUs
    Examples:
      | username | password    |
      | 101203   | Dmart@12345 |



#    1)positive plow 4 items picking
#    2)total 7 items are there first 4 items are one hu and second 3 items are 2 hu and close hu
#    3)confir quantity-0, incorrect quantity -short , damaged, hu fill clikc on submit