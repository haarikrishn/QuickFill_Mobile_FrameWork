Feature:offline: update task  by refiller in offline Mode

  @UpdateTaskByRefiller
  Scenario Outline:update task by refiller
    Given Enter username "<username>" and password "<password>" to login to the QuickFill application
When  user enter into Tasks Page Refiller should complete all tasks
    Examples:
      | username | password   |
      | 555102 | Dmart@123 |

  @UpdateTaskByAll
  Scenario Outline:update task by refiller
    Given Enter username "<username>" and password "<password>" to login to the QuickFill application
    When get all priceBoard details
      | FullPriceBoard   | A4/1 - Full page price board      |
      | HalfPriceBoard   | A4/2 - Half page price board      |
      | MediumPriceBoard | A4/4 - Medium price board         |
      | smallPriceBoard  | A4/9 - Cosmetic small price board |
    And  user enter into Tasks Page Refiller should complete all tasks All
      | TaskTypeRefill   | Refill                         |
      | TaskTypeOther    | Other                          |
      | TaskTypeBoard    | Board                          |
      | RefilledQuantity | 5                              |
      | OthersComment    | Required quantity was refilled|

    Examples:
      | username | password  |
      | 555102 | Dmart@123 |
#===================================================================================
#offline


#===================================================================================================================
