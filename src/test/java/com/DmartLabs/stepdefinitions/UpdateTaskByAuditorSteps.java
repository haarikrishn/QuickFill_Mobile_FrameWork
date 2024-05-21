package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.AuditorTasksPage;
import com.DmartLabs.bdd.pages.LoginPage;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class UpdateTaskByAuditorSteps {

    private AuditorTasksPage auditorTasksPage;

    @And("Verify that user is in Tasks page")
    public void verifyThatUserIsInTasksPage() {
        QXClient.get().report().info("Verify that user is in Tasks page");
        auditorTasksPage = new AuditorTasksPage();
        auditorTasksPage.isTaskPageDisplayed();
    }

    @And("Click on Open tab")
    public void clickOnOpenTab() {
        QXClient.get().report().info("Click on Open tab");
        auditorTasksPage.clickOnOpenTab();
    }

    @When("Close the tasks")
    public void closeTheTasks() {
        QXClient.get().report().info("Close the tasks");
//        auditorTasksPage.getTaskSize();
        auditorTasksPage.getTasksNames();
        auditorTasksPage.closeTasks();
    }

    @Then("Verify that tasks are closed")
    public void verifyThatTasksAreClosed() {
        QXClient.get().report().info("Verify that tasks are closed");
        //auditorTasksPage.verifyClosedTasks();
        auditorTasksPage.verifySyncedAndClosedTasks();
    }

    @Then("Verify that tasks are synced and closed")
    public void verifyThatTasksAreSyncedAndClosed() {
        auditorTasksPage.verifySyncedAndClosedTasks();
    }
}
