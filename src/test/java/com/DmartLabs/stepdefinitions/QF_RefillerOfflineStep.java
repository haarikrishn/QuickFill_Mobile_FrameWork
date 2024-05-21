package com.DmartLabs.stepdefinitions;
import com.DmartLabs.bdd.pages.QF_RefillerOfflinePage;
import io.cucumber.java.en.When;
public class QF_RefillerOfflineStep {

    QF_RefillerOfflinePage qf_refillerOfflinePage=new QF_RefillerOfflinePage();

    @When("user enter into Tasks Page Refiller should complete all tasks")
    public void userEnterIntoTasksPageRefillerShouldCompleteAllTasks() throws InterruptedException {
Thread.sleep(5000);


       int[] location = qf_refillerOfflinePage.getLocation();
        System.out.println(location+"===========location");
    //   qf_refillerOfflinePage. getAllItemsNew(location);
     //   qf_refillerOfflinePage.getAllItems();
        qf_refillerOfflinePage.PrintAllIems();
        qf_refillerOfflinePage.completeTheTask();
    }


    @When("user enter into Tasks Page Refiller should complete all Three tasks")
    public void userEnterIntoTasksPageRefillerShouldCompleteAllThreeTasks() throws InterruptedException {
        int[] location = qf_refillerOfflinePage.getLocation();
        System.out.println(location.toString()+"===========location");
          qf_refillerOfflinePage. getAllItemsNew(location);
        qf_refillerOfflinePage.PrintAllIems();

    }
}

