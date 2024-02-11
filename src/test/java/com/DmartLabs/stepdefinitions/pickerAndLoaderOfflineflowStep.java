package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.*;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashSet;
import java.util.Set;

public class pickerAndLoaderOfflineflowStep {
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    picker1TwoHUsOfflinepage picker1TwoHUsOfflinepageObj=new picker1TwoHUsOfflinepage();
    PickerInvalidQuantityOfflinePage pickerInvalidQuantityOfflinePageObj=new PickerInvalidQuantityOfflinePage();
    picker1Page picker1Page =new picker1Page();

//============================================================================================================

    @When("user verify the items one By One  and move to PickerSevenItems in offline mode")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsInOfflineMode() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1Page.PickListDetails();
        picker1Page.addElementsToList();
        Thread.sleep(2000);
        picker1Page.offlineModeClickItemOneByone();

        //   picker1Page.PickListDetails();
        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.offlineModeClickItemOneByone1();
        Thread.sleep(2000);
        picker1Page.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1Page.offlineModeClickOnCloseHU();
    }
    @Then("verify Items picked or not")
    public void verifyItemsPickedOrNot() throws InterruptedException {
        Thread.sleep(1000);
        picker1Page.EmptyListDisplayed();
    }

    //=================================================================================================
//  @PickerOneDeliveryTwoHUsAndLoadInOfflineMode

    @When("user verify the items one By One  and move to pickList one HU in offline")
    public void userVerifyTheItemsOneByOneAndMoveToPickListOneHUInOffline() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.PickListDetailsInOffline();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.addElementsToListFirstHUInOffline();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.ClickItemOneByoneInoffline();
        picker1TwoHUsOfflinepageObj.ClickONViewHU();
        Thread.sleep(500);
        picker1TwoHUsOfflinepageObj.HUpageIsDisplayed();
        Thread.sleep(500);
        picker1TwoHUsOfflinepageObj.ClickOnCloseHUInOffline();

        // picker1TwoHUspage.scrollElementsForSecondHU();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.addElementsToListSecondHUInOffline();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.ClickItemOneByoneSecondHUInOffline();
        Thread.sleep(500);
        picker1TwoHUsOfflinepageObj.HUpageIsDisplayed();
        Thread.sleep(500);
        picker1TwoHUsOfflinepageObj.ClickOnSecondHuCloseHUInOffline();
    }

//================================================================================================================
//  @PickerInvalidQunatityAndLoadInOfflineMode

    @When("user verify the items one By One  and move to pickList with invalid Quantity in offline mode")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithInvalidQuantityInOfflineMode(DataTable dataTable) throws InterruptedException {

        Thread.sleep(2000);
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.PickListDetails();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.addElementsToinvalidQuantity();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.ClickItemOneByone(dataTable);
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.addElementsToinvalidQuantity1();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.ClickItemOneByone1();
        pickerInvalidQuantityOfflinePageObj.HUpageIsDisplayed();
        pickerInvalidQuantityOfflinePageObj.ClickOnCloseHU();

    }

}
