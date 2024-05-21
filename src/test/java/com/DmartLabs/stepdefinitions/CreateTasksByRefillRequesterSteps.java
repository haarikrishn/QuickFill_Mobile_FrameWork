package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.CreateTaskPage;
import com.DmartLabs.bdd.pages.FloorWalkPage;
import com.DmartLabs.bdd.pages.TasksPage;
import com.DmartLabs.commonutils.ExtentManager;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class CreateTasksByRefillRequesterSteps {

    private CreateTaskPage createTaskPage;
    private TasksPage taskPage;
    private List<Map<String, String>> taskDetails;
    private FloorWalkPage floorWalkPage;

    @And("Verify that Requester is in Create Tasks page")
    public void verifyThatRequesterIsInCreateTasksPage() {
        QXClient.get().report().info("Verify that Requester is in Create Tasks page");
        createTaskPage = new CreateTaskPage();
        createTaskPage.verifyCreateTaskPageIsDisplayed();
    }

    @And("Enter the Ean Numbers in Search box, select the task type and create the tasks")
    public void enterTheEanNumbersInSearchBoxSelectTheTaskTypeAndCreateTheTasks(DataTable dataTable) {
        QXClient.get().report().info("Enter the Ean Numbers in Search box, select the task type and create the tasks");
        taskDetails = dataTable.asMaps();
        createTaskPage.createTasks(taskDetails);
    }

    @And("Click on Tasks Button")
    public void clickOnTasksButton() {
        QXClient.get().report().info("Click on Tasks Button");
        createTaskPage.clickOnTaskBtn();
    }

    @And("Verify that Tasks page is displayed")
    public void verifyThatTasksPageIsDisplayed() {
        QXClient.get().report().info("Verify that Tasks page is displayed");
        taskPage = new TasksPage();
        taskPage.verifyTaskPageIsDisplayed();
    }

    @And("Click on Open tab in Tasks page")
    public void clickOnOpenTabInTasksPage() {
        QXClient.get().report().info("Click on Open tab in Tasks page");
        taskPage.clickOnOpenTab();
    }

    @Then("Verify that the Task is created successfully")
    public void verifyThatTheTaskIsCreatedSuccessfully() {
        QXClient.get().report().info("Verify that the Task is created successfully");
        taskPage.verifyTasks(taskDetails);
    }

    @And("Click on Floor Walk button")
    public void clickOnFloorWalkButton() {
        QXClient.get().report().info("Click on Floor Walk button");
        taskPage.clickOnFloorWalkBtn();
    }

    @And("Verify that Refill Requester is in Floor Walk Summary page")
    public void verifyThatRefillRequesterIsInFloorWalkSummaryPage() {
        QXClient.get().report().info("Verify that Refill Requester is in Floor Walk Summary page");
        floorWalkPage = new FloorWalkPage();
        floorWalkPage.verifyFloorWalkPage();
    }

    @And("Verify that FloorWalk is Created")
    public void verifyThatFloorWalkIsCreated() {
        QXClient.get().report().info("Verify that FloorWalk is Created");
        floorWalkPage.verifyFloorWalkCreated();
    }

    @And("Verify that Floorwalk is in {string}")
    public void verifyThatFloorwalkIsIn(String status) {
        QXClient.get().report().info("Verify that Floorwalk is in "+status);
        floorWalkPage.verifyFloorwalkStatus(status);
    }

    @And("Verify that Open Task is same as Task created")
    public void verifyThatOpenTaskIsSameAsTaskCreated() {
        QXClient.get().report().info("Verify that Open Task is same as Task created");
        floorWalkPage.verifyOpenTaskInFloorwalk(taskDetails.size());
    }

    @Then("Go back to Tasks page")
    public void goBackToTasksPage() {
        QXClient.get().report().info("Go back to Tasks page");
        floorWalkPage.clickOnBackBtn();
    }

    @And("Go to Create Task page")
    public void goToCreateTaskPage() {
        QXClient.get().report().info("Go to Create Task page");
        taskPage.clickOnBackBtn();
    }

    @And("Close the Floorwalk")
    public void closeTheFloorwalk() {
        QXClient.get().report().info("Close the Floorwalk");
        createTaskPage.closeFloorwalk();
    }
}
