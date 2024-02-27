Feature: online BoxAndDispatchType:Pick the items in Delivery and load the Delivery into the truck

  @PickerInvalidQunatityOnlineBoxAndDispatchTypeOnlyHUFULLorPalletFull
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity BoxAndDispatchType
      | HUFullItem     | HU Full     |
      | PalletFullItem | Pallet Full |
    And  user verify the items one By One  and move to pickList without InvalidQuantity
      | ItemName                           | Reason             | RemoveQuantity |
      | Colgate Maxfresh Blue Gel Tp(300g) | HuFullOrPalletFull | 1              |
      | Oral B Kids 2+ Year Toothbrush(3n) | HuFullOrPalletFull | 1              |
    And  user verify the items one By One  and move to pickList without InvalidQuantity remaining items
    Then verify Items picked or not
    And Logout the user from application
    Examples:
      | username   | password   |
      | 121346   | Sweety123@ |
#     | 9000680178 | Sweety123@ |
#      | 101203   | Dmart@12345 |

  @PickerInvalidQunatityOnlineBoxAndDispatchTypeOnlySHort_Damage_WrongArticle
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity BoxAndDispatchType
      | ShortItem        | Short         |
      | DamagedItem      | Damaged       |
      | WrongArticleItem | Wrong article |
    And  user verify the items one By One  and move to pickList without InvalidQuantity
      | ItemName                            | Reason        | RemoveQuantity |
      | Pampers Aloe Baby Wips(72n)         | Short         | 1              |
      | Boroplus Alov Hal Ch Kes Gel(150ml) | Damaged       | 1              |
      | Colgate Maxfresh Blue Gel Tp(300g)  | Wrong article | 1              |
    Then verify Items picked or not
    And Logout the user from application
    Examples:
      | username   | password   |
      | 121346   | Sweety123@ |
#     | 9000680178 | Sweety123@ |
#      | 101203   | Dmart@12345 |



