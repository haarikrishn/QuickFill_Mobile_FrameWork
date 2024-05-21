package com.DmartLabs.stepdefinitions;
import com.DmartLabs.bdd.pages.QF_AllOfflinePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class QF_23_OfflineUpdateTaskByRefillerStep {
    QF_AllOfflinePage qf_allOfflinePage=new QF_AllOfflinePage();



    @When("get all priceBoard details In offlineMode")
    public void getAllPriceBoardDetailsInOfflineMode(DataTable dataTable) {
        qf_allOfflinePage.getPriceBoardsOffline(dataTable);

    }

    @And("user enter into Tasks Page Refiller should complete all tasks in offlineMode")
    public void userEnterIntoTasksPageRefillerShouldCompleteAllTasksInOfflineMode(DataTable dataTable) throws InterruptedException {
        qf_allOfflinePage.completeAllTheTask1(dataTable);
        Thread.sleep(500);
        qf_allOfflinePage.closeOffline(dataTable);


    }
}

