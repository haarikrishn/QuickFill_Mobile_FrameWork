Feature: Verify the functionality of Create Task by Requester

#  Scenario Outline: Create Tasks by Refill Requester
#    Given Enter username "<username>" and password "<password>" to login to the QuickFill application
#    And Verify that Requester is in Home page
#    And Enter the Ean Number in Search box
#    And Select the Task to be created for
#    And Enter the number of boxes required for Refill Task
#    And Select the price boards
#    And Enter the comments
#    And Click on CREATE REFILL TASK button
#    And Click on CREATE PRICE BOARD TASK
#    And Click on CREATE OTHERS TASK button
#    And Verify that Review Refill Task PopUp is displayed
#    And Verify that Review Priceboard Task PopUp is displayed
#    And Verify that Review Others Task PopUp is displayed
#    And Click on CONFIRM button
#    And Click on CANCEL  button
#    And Click on Tasks Link
#    And Verify that Tasks page is displayed
#    And Click on Open tab
#    Then Verify that the Task is created successfully
#    Examples:
#      | username | password  |
#      | 678787   | Dmart@123 |

  @CreateTasks
   Scenario: Create Multiple Tasks by Refill Requester
    Given Enter username "6789014" and password "Dmart@12345" to login to the QuickFill application
    And Verify that Requester is in Create Tasks page
    And Enter the Ean Numbers in Search box, select the task type and create the tasks
      | ean           | taskType | requestedQuantity | priceboards                                                                      | requesterComments     |
      | 8901030962226 | Refill   | 10                |                                                                                  |                       |
      | 8901030970672 | Board    |                   | A4/4 - Medium price board,A4/1 - Full page price board,A4/10 - Strip price board | Check Priceboard task |
      | 8901030818233 | Other    |                   |                                                                                  | Creating Others task  |
    And Click on Tasks Button
    And Verify that Tasks page is displayed
    And Click on Open tab in Tasks page
    Then Verify that the Task is created successfully
    And Click on Floor Walk button
    And Verify that Refill Requester is in Floor Walk Summary page
    And Verify that FloorWalk is Created
    And Verify that Floorwalk is in "In-Progress"
    And Verify that Open Task is same as Task created
    Then Go back to Tasks page
    And  Go to Create Task page
    And Close the Floorwalk

