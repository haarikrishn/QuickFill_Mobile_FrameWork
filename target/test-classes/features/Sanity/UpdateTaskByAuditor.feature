Feature: Verify the functionality of update task by auditor
  @UpdateTaskByAuditor
  Scenario Outline: Update task by auditor
    Given Enter username "<username>" and password "<password>" to login to the QuickFill application
    And Verify that user is in Tasks page
    And Click on Open tab
    When Close the tasks
    Then Verify that tasks are closed
    Examples:
      | username | password  |
      | 678787   | Dmart@123 |