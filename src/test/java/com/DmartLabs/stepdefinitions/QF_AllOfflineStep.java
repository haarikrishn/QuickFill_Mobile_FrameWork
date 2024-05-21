package com.DmartLabs.stepdefinitions;
import com.DmartLabs.bdd.pages.QF_AllOfflinePage;
import com.DmartLabs.bdd.pages.QF_RefillerOfflinePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class QF_AllOfflineStep {
    QF_AllOfflinePage qf_allOfflinePage=new QF_AllOfflinePage();


    @When("get all priceBoard details")
    public void getAllPriceBoardDetails(DataTable dataTable) {

     //   qf_allOfflinePage.PriceBoardList();
        qf_allOfflinePage.getPriceBoards(dataTable);
    }


    @And("user enter into Tasks Page Refiller should complete all tasks All")
    public void userEnterIntoTasksPageRefillerShouldCompleteAllTasksAll(DataTable dataTable) throws InterruptedException {

        qf_allOfflinePage.completeAllTheTask(dataTable);

    }



}

